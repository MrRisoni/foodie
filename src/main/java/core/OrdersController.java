package core;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import models.*;
import models.order.Order;
import models.order.OrderItem;
import models.order.OrderItemIngredient;
import models.order.PaymentMethod;
import models.shop.Food;
import models.shop.Ingredient;
import models.shop.Shop;
import models.users.User;
import models.users.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojos.Basket;
import spring_repos.*;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
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
    OrderItemIngredientRepository orderItemIngrRepo;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/api/place_order", method = RequestMethod.POST)
    public ResponseEntity<String> placeOrder(@RequestBody Object postData) {
        try {
            System.out.println(postData);
            Gson g = new Gson();
            Basket kalathi = new Gson().fromJson(g.toJson(postData), Basket.class);

            EntityManager em = HibernateUtil.getEM();
            PaymentMethod pm = em.createQuery("FROM PaymentMethod WHERE title =:fop", PaymentMethod.class)
                    .setParameter("fop", kalathi.getFop().getTitle()).getSingleResult();

            User usr = new User();
            usr.setId(kalathi.getUserId());

            UserAddress addr = new UserAddress();
            addr.setAddId(kalathi.getAddressId());

            BigDecimal sum = new BigDecimal(3);
            BigDecimal totalFoodPrice = new BigDecimal(0);

            List<OrderItem> persistOrderItems = new ArrayList<>();

            for (OrderItem postOi : kalathi.getOrderItems()) {
                totalFoodPrice = new BigDecimal(0);

                List<OrderItemIngredient> desiredIngredients = new ArrayList<>();

                //get the price from db
                Optional<Food> fetcableFood = fdRepo.findById(postOi.getFoodObj().getId());
                Food fai = fetcableFood.orElse(null);
                System.out.println("Food id " + postOi.getFoodObj().getId() + " price " + fai.getPrice());
                sum = sum.add(fai.getPrice());

                totalFoodPrice = totalFoodPrice.add(fai.getPrice());

                System.out.println("TOTAL INGREDIENTS " + postOi.getIngredients().size());

                for (OrderItemIngredient selectedIngr : postOi.getIngredients()) {
                    Optional<Ingredient> fetcableIngr = ingrRepo.findById(selectedIngr.getIngredientObj().getId());
                    Ingredient ingr = fetcableIngr.orElse(null);
                    System.out.println("Cost of ingredient " + ingr.getId() + " is " + ingr.getPrice());
                    sum = sum.add(ingr.getPrice());
                    totalFoodPrice = totalFoodPrice.add(ingr.getPrice());

                    desiredIngredients.add(new OrderItemIngredient(ingr, ingr.getPrice()));
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
                pItm.setOrderObj(new Order(savedOrder.getId()));
                OrderItem savedItm = ordItemRepo.save(pItm);
                for (OrderItemIngredient pItmIng : pItm.getIngredients()) {
                    pItmIng.setOrderItemObj(savedItm);
                    orderItemIngrRepo.save(pItmIng);
                }
            }

            return new ResponseEntity<>(savedOrder.getId().toString(), HttpStatus.BAD_GATEWAY);

        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_GATEWAY);
        }
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
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }


    @RequestMapping(value = "/api/order/show", method = RequestMethod.GET)
    public ResponseEntity<String> getOrderDetails() {

        try {
            Optional<Order> fetchedOrder = ordRepo.findById(1L);
            Order returnedOrder = fetchedOrder.orElse(null);

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
            String json=  mapper.writerWithView(View.IOrder.class).writeValueAsString(returnedOrder);
            return new ResponseEntity<>(json,HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_GATEWAY);
        }
    }

}
