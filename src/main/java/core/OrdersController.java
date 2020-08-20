package core;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pojos.Basket;
import spring_repos.FoodRepository;
import spring_repos.IngredientRepository;
import spring_repos.OrderRepository;
import spring_repos.OrderItemRepository;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class OrdersController {

    @Autowired
    IngredientRepository ingrRepo;

    @Autowired
    FoodRepository fdRepo;

    @Autowired
    OrderRepository ordRepo;

    @Autowired
    OrderItemRepository ordItemRepo;

    @Autowired
    private HttpSession session;

    @RequestMapping(value=  "/api/place_order" , method = RequestMethod.POST)
    public String placeOrder( @RequestBody Object postData) {

        System.out.println(postData);
        Gson g = new Gson();
        Basket kalathi = new Gson().fromJson(g.toJson(postData), Basket.class);

        EntityManager em = HibernateUtil.getEM();
        PaymentMethod pm = em.createQuery("FROM PaymentMethod WHERE title =:fop",PaymentMethod.class)
        .setParameter("fop",kalathi.getFop().getTitle()).getSingleResult();

        User usr = new User();
        usr.setId(kalathi.getUserId());

        UserAddress addr = new UserAddress();
        addr.setAddId(kalathi.getAddressId());

        BigDecimal sum  = new BigDecimal(3);
        BigDecimal totalFoodPrice  = new BigDecimal(0);

        List<OrderItem> persistOrderItems = new ArrayList<>();

        for (OrderItem postOi : kalathi.getOrderItems()){
            totalFoodPrice  = new BigDecimal(0);

            List<OrderItemIngredient> desiredIngredients = new ArrayList<>();

            //get the price from db
            Optional<Food> fetcableFood = fdRepo.findById(postOi.getFoodObj().getId());
            Food fai = fetcableFood.orElse(null);
            System.out.println("Food id " + postOi.getFoodObj().getId() + " price " + fai.getPrice());
            sum = sum.add(fai.getPrice());

            totalFoodPrice = totalFoodPrice.add(fai.getPrice());


            System.out.println("TOTAL INGREDIENTS " +  postOi.getIngredients().size());

            for (OrderItemIngredient selectedIngr: postOi.getIngredients()) {
                Optional<Ingredient> fetcableIngr = ingrRepo.findById(selectedIngr.getIngredientObj().getId());
                Ingredient ingr = fetcableIngr.orElse(null);
                System.out.println("Cost of ingredient " + ingr.getId() + " is " + ingr.getPrice() );
              //  sum.add(ingr.getPrice());
                totalFoodPrice =totalFoodPrice.add(ingr.getPrice());

                desiredIngredients.add(new OrderItemIngredient(ingr));
            }


            OrderItem itm = new OrderItem();
            itm.setBase_price(fai.getPrice());
            itm.setFinal_price(totalFoodPrice);
            itm.setFoodObj(new Food(postOi.getFoodObj().getId()));
            itm.setShopObj(new Shop(postOi.getShopObj().getId()));
            itm.setIngredients(desiredIngredients);

            persistOrderItems.add(itm);
        }

        System.out.println("TOTAL SUM IS " + sum);

        Order o = new Order();
        o.setPayObj(pm);
        o.setUserObj(usr);
        o.setAddrObj(addr);
        o.setSuccess(true);
        o.setFinal_price(sum);
        Order savedOrder = ordRepo.save(o);

        System.out.println("GET NEW ORDER ID " + savedOrder.getId());
         for (OrderItem pItm : persistOrderItems) {
             pItm.setOrderObj(savedOrder);
             ordItemRepo.save(pItm);
         }


        
        return "foo";
    }

        @PostMapping(value = "/api/order/update_basket",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public String addToBasket(@RequestBody Object postData) {
        try {
           // session.setAttribute("foo", "bar");
            System.out.println(postData);
            Gson g = new Gson();
            Basket kalathi = new Gson().fromJson(g.toJson(postData), Basket.class);

            System.out.println("Deserialize");
            System.out.println(kalathi.getDonations().get(0).getId());
            System.out.println("FOP " + kalathi.getFop().getTitle());
            System.out.println("foodObj ID " + kalathi.getOrderItems().get(0).getFoodObj().getId());
            System.out.println("commenx " + kalathi.getOrderItems().get(1).getComment());

            System.out.println("ingred id " + kalathi.getOrderItems().get(0).getIngredients().get(0).getIngredientObj().getId());
             session.setAttribute("foo", kalathi);

            //System.out.println(kalathi.getFoodId());
           // System.out.println(kalathi.getIngredients().size());
           // System.out.println(session.getAttribute("foo"));
            return "ok " + session.getAttribute("totalPrice");
        }
        catch (Exception ex) {
            return ex.getMessage();
        }
    }


    @RequestMapping(value=  "/api/order/show" , method = RequestMethod.GET)
    public String getOrderDetails() {

        try {
            Optional<Order> fetchedOrder = ordRepo.findById(1L);
            Order returnedOrder = fetchedOrder.orElse(null);

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
            return mapper.writerWithView(View.IOrder.class).writeValueAsString(returnedOrder);
        }
        catch (Exception ex){
            return ex.getMessage();
        }
    }

}
