package core;

import models.Cuisine;
import models.HibernateUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class BrowseController {

    @RequestMapping(value=  "/api/browse" , method = RequestMethod.GET)
    public HashMap<String,Object> getData()
    {
        HashMap<String,Object> rsp = new HashMap<>();

        rsp.put("cusines", HibernateUtil.getEM().createQuery("FROM Cuisine ORDER BY name ASC", Cuisine.class).getResultList());
        return rsp;
     }
}
