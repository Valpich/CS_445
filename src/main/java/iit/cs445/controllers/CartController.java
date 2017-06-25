package iit.cs445.controllers;

import iit.cs445.models.orders.OrderService;
import iit.cs445.models.users.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class CartController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String listAll(Model model) {
        return "cart/list";
    }

    @RequestMapping(value = "/cart/checkout", method = RequestMethod.GET)
    public String checkout(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart.getListCount() <= 0){
            return "cart/list";
        }
        return "cart/checkout";
    }
}
