package core;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Order;
import models.View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring_repos.OrderRepository;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Optional;

@CrossOrigin
@RestController
public class OrdersController {

    @Autowired
    OrderRepository ordRepo;

    @RequestMapping(value=  "/api/order/add_basket" , method = RequestMethod.GET)
    public String addToBasket(HttpSession session) {
        session.setAttribute("foo","bar");
        System.out.println(session.getAttribute("foo"));
        return "ok " + session.getAttribute("totalPrice");
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
