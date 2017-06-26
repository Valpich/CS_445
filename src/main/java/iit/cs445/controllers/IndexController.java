package iit.cs445.controllers;

import iit.cs445.models.products.Cable;
import iit.cs445.models.services.CustomService;
import iit.cs445.models.users.Address;
import iit.cs445.models.users.Cart;
import iit.cs445.models.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index");
        User user = new User();
        user.setFirstName("Antoine");
        user.setLastName("Regnier");
        user.setEmail("antoine@regnier.com");
        user.setPassword("qaws1234");
        List<Address> addresses = new ArrayList<>();
        Address address = new Address();
        address.setCity("Chicago");
        address.setCountry("USA");
        address.setFirstName("Antoine");
        address.setLastName("Regnier");
        address.setPhoneNumber("(123) 456 - 7890");
        address.setState("Illinois");
        address.setZipCode("60614");
        address.setStreetAddress("1234, Fullerton Ave");
        addresses.add(address);
        user.setAddresses(addresses);
        user.saveNew();
        return modelAndView;
    }

}
