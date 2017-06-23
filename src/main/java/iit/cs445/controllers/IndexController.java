package iit.cs445.controllers;

import iit.cs445.models.products.Cable;
import iit.cs445.models.users.Address;
import iit.cs445.models.users.User;
import iit.cs445.models.users.UserCart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("controller", new String("Coucou toi!"));
        UserCart cart = (UserCart) session.getAttribute("cart");
        if(cart != null){
            cart.addProduct(new Cable());
        }
        return modelAndView;
    }

}
