package iit.cs445.controllers;

import iit.cs445.models.orders.Order;
import iit.cs445.models.orders.OrderService;
import iit.cs445.models.users.Address;
import iit.cs445.models.users.Cart;
import iit.cs445.models.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
public class CartController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String listAll() {
        return "cart/list";
    }

    @RequestMapping(value = "/cart/checkout", method = RequestMethod.GET)
    public String checkoutGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart.getListCount() <= 0){
            return "cart/list";
        }
        Logger.getLogger(CartController.class.getName()).log(Level.INFO, "find by id " + new User().findById(1L));
        return "cart/checkout";
    }

    @RequestMapping(value = "/cart/checkout", method = RequestMethod.POST)
    public String checkoutPost(HttpServletRequest request, @RequestParam("billing_address") Long billingAddress ) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart.getListCount() <= 0){
            return "cart/list";
        }
        Order order = new Order();
        order.setBillingAddress(new Address().findById(billingAddress));
        return "order/confirmation";
    }
}
