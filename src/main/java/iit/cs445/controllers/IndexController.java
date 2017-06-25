package iit.cs445.controllers;

import iit.cs445.models.products.Cable;
import iit.cs445.models.services.CustomService;
import iit.cs445.models.users.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("controller", new String("Coucou toi!"));
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            Cable cable = new Cable();
            cable.setId(new Long(2));
            cable.setPrice(new Float(44.2));
            cable.setLength(new Float(24.3));
            cable.setDescription("Cable test");
            cart.add(cable);
            CustomService customService = new CustomService();
            customService.setId(new Long(3));
            customService.setPrice(new Float(32.2));
            customService.setDescription("Service test");
            cart.add(customService);
        }
        return modelAndView;
    }

}
