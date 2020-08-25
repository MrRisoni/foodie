package core;

import models.shop.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring_repos.FoodRepository;

import java.util.HashMap;
import java.util.Optional;

@CrossOrigin
@RestController
public class FoodController {

    @Autowired
    FoodRepository foodrepo;

    @RequestMapping(value=  "/api/food" , method = RequestMethod.GET)
    public HashMap<String,Object> getFoodItems()
    {
        Optional<Food> fetched = foodrepo.findById(1L);
        Food fai = fetched.orElse(null);

        HashMap<String ,Object> rsp = new HashMap<>();
        rsp.put("food",fai);
        return rsp;
    }
}
