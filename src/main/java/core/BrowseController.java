package core;

import models.Cuisine;
import models.HibernateUtil;
import models.Restaurant;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring_repos.UserRepository;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class BrowseController {

    @Autowired
    UserRepository usrRepo;

    @RequestMapping(value=  "/api/browse" , method = RequestMethod.GET)
    public HashMap<String,Object> getData()
    {
        EntityManager em = HibernateUtil.getEM();
        HashMap<String,Object> rsp = new HashMap<>();
        Long userId = 1L;
        rsp.put("cusines", em.createQuery("FROM Cuisine ORDER BY name ASC", Cuisine.class).getResultList());

        Optional<User> fetchedUser = usrRepo.findById(userId);
        User foundUsr  = fetchedUser.orElse(null);

        HashMap<Long,String> favorites = new HashMap<>();
        List<Restaurant> favs = foundUsr.getFavoriteRestaurants();

        for (Restaurant fv : favs) {
            favorites.put(fv.getId(),fv.getName());
        }

        rsp.put("favorites",favorites);

        return rsp;


     }
}
