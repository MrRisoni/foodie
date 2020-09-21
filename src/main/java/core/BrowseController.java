package core;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.*;
import models.shop.Cuisine;
import models.shop.Menu;
import models.shop.Restaurant;
import models.shop.RestaurantCuisine;
import models.users.User;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spring_repos.RestaurantRepository;
import spring_repos.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
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

    @RequestMapping(value = "/api/filter/cuisine", method = RequestMethod.GET)
    public ResponseEntity<Object> filterCuisines() {
        try {
            String search = "1 2 3";
            ArrayList<String> items = new ArrayList<>();
            for (String cu : search.split(" ")) {
                items.add("'" + cu + "'");
            }


            return new ResponseEntity<>(HibernateUtil.getEM().createNativeQuery("SELECT r.id , r.name FROM restaurants r" +
                    " JOIN restaurants_cuisines rc ON rc.restaurants_id =  r.id " +
                    " WHERE  rc.cuisines_id IN (" + String.join(",", items) + ")")
                    .unwrap(org.hibernate.query.NativeQuery.class)
                    .addScalar("id", StandardBasicTypes.LONG)
                    .addScalar("name", StandardBasicTypes.STRING)
                    .setResultTransformer(Transformers.aliasToBean(Restaurant.class))
                    .getResultList(),HttpStatus.OK);


        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @RequestMapping(value = "/api/menu", method = RequestMethod.GET)
    public List<Menu> getMenu() {

        Optional<Restaurant> fetchedResto = mnRepo.findById(1L);
        Restaurant resto = fetchedResto.orElse(null);
        return resto.getMenu();
    }

    @RequestMapping(value = "/api/home", method = RequestMethod.GET)
    public ResponseEntity<Object> getData() {
        try {
            EntityManager em = HibernateUtil.getEM();
            HashMap<String, Object> rsp = new HashMap<>();
            Long userId = 1L;
            Long selectedAddrerss = 1L;
            rsp.put("cuisines", em.createQuery("FROM Cuisine ORDER BY name ASC", Cuisine.class).getResultList());

            List<Restaurant> favs = em.createNativeQuery("SELECT fv.restaurant_id AS id " +
                    " ,r.name " +
                    "FROM  users_favorite_restaurants fv" +
                    " JOIN restaurants r ON r.id = fv.restaurant_id" +
                    " WHERE fv.user_id = :usrId ").setParameter("usrId", userId)
                    .unwrap(org.hibernate.query.NativeQuery.class)
                    .addScalar("id", StandardBasicTypes.LONG)
                    .addScalar("name", StandardBasicTypes.STRING)
                    .setResultTransformer(Transformers.aliasToBean(Restaurant.class))
                    .getResultList();

            rsp.put("favorites", favs);

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
                            " AND usa.add_id =:addrid")
                    .setParameter("usrid", userId)
                    .setParameter("addrid", selectedAddrerss)
                    .unwrap(org.hibernate.query.NativeQuery.class)
                    .addScalar("id", StandardBasicTypes.LONG)
                    .addScalar("name", StandardBasicTypes.STRING)
                    .setResultTransformer(Transformers.aliasToBean(Restaurant.class))
                    .getResultList());

            return new ResponseEntity<>(rsp,HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_GATEWAY);
        }

    }
}
