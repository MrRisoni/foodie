package core;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring_repos.RestaurantRepository;
import spring_repos.UserRepository;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class BrowseController {

    @Autowired
    UserRepository usrRepo;

    @Autowired
    RestaurantRepository mnRepo;

    @RequestMapping(value=  "/api/menu" , method = RequestMethod.GET)
    public List<Menu> getMenu() {

        Optional<Restaurant> fetchedResto = mnRepo.findById(1L);
        Restaurant resto  = fetchedResto.orElse(null);
        return resto.getMenu();
    }

    @RequestMapping(value=  "/api/browse" , method = RequestMethod.GET)
    public HashMap<String,Object> getData()
    {
        try {
            EntityManager em = HibernateUtil.getEM();
            HashMap<String, Object> rsp = new HashMap<>();
            Long userId = 1L;
            Long selectedAddrerss = 1L;
            rsp.put("cusines", em.createQuery("FROM Cuisine ORDER BY name ASC", Cuisine.class).getResultList());

            Optional<User> fetchedUser = usrRepo.findById(userId);
            User foundUsr = fetchedUser.orElse(null);

            HashMap<Long, String> favorites = new HashMap<>();
            List<Restaurant> favs = foundUsr.getFavoriteRestaurants();

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);

            rsp.put("favorites", mapper.writerWithView(View.IFavoriteRestau.class).writeValueAsString(favs));


            for (Restaurant fv : favs) {
                favorites.put(fv.getId(), fv.getName());
            }
            // get all other restaurants that serve the users suburb address
            // and that are not in his favorites

            rsp.put("restaurants", em.createNativeQuery(
                    " SELECT r.id , r.name FROM " +
                            " restaurants r " +
                            " LEFT JOIN " +
                            " users_favorite_restaurants  fv ON (fv.restaurant_id = r.id AND  fv.user_id = :usrid) " +
                            " JOIN shops s ON s.restaurants_id = r.id " +
                            " JOIN  shops_serving_suburbs ssbs ON ssbs.sssb_shop_id = s.id " +
                            " JOIN users_addresses usa ON usa.add_suburb_id =  sssb_suburb_id " +
                            " WHERE  fv.restaurant_id IS NULL " +
                            " AND usa.add_id =:addrid").setParameter("usrid", userId).setParameter("addrid", selectedAddrerss).getResultList());


            return rsp;
        }
        catch (Exception ex)
        {
            return null;
        }

     }
}
