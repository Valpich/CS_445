package iit.cs445.controllers;

import iit.cs445.models.users.Address;
import iit.cs445.models.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("controller", new String("Coucou toi!"));
        User user = new User();
        user.setEmail("coucou@hotmail.fr");
        Address ad = new Address();
        ad.setCreationTime(new Date());
        ad.setModificationTime(new Date());
      //  ad.saveNew();
        Address ad2 = new Address();
        ad2.setCreationTime(new Date());
        ad2.setModificationTime(new Date());
       // ad2.saveNew();
        ArrayList addresses = new ArrayList();
        addresses.add(ad);
        addresses.add(ad2);
        user.setAddress(addresses);
        user.setCreationTime(new Date());
        user.setModificationTime(new Date());
        user.setFirstName("Antoine");
        user.setLastName("Regnier");
//        user.saveNew();
        user.listAll();
        return modelAndView;
    }

}
