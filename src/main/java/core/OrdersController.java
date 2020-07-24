package core;

import models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring_repos.OrderRepository;

import java.util.HashMap;
import java.util.Optional;

@CrossOrigin
@RestController
public class OrdersController {

    @Autowired
    OrderRepository ordRepo;

    @RequestMapping(value=  "/api/order/show" , method = RequestMethod.GET)
    public Order getOrderDetails()
    {
        Optional<Order> fetchedOrder= ordRepo.findById(1L);
        return fetchedOrder.orElse(null);
    }
}
