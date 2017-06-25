package iit.cs445.controllers;

import iit.cs445.models.orders.Order;
import iit.cs445.models.orders.OrderService;
import iit.cs445.models.orders.OrderStatus;
import iit.cs445.models.products.Product;
import iit.cs445.models.services.Service;
import iit.cs445.models.users.Address;
import iit.cs445.models.users.Cart;
import iit.cs445.models.users.User;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
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
        saveCart(request, 21L, 21L);
        Logger.getLogger(CartController.class.getName()).log(Level.INFO, "find by id " + new User().findById(1L));
        return "cart/checkout";
    }

    @RequestMapping(value = "/cart/checkout", method = RequestMethod.POST)
    public String checkoutPost(HttpServletRequest request, @RequestParam("billing_address") Long billingAddress ,
                               @RequestParam("shipping_address") Long shippingAddress ) {
        if (saveCart(request, billingAddress, shippingAddress)) return "cart/list";
        return "order/confirmation";
    }

    private boolean saveCart(HttpServletRequest request, Long billingAddress, Long shippingAddress) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart.getListCount() <= 0){
            return true;
        }
        Order order = new Order();
        order.setBillingAddress(new Address().findById(billingAddress));
        order.setStatus(OrderStatus.PROCESSING);
        order.setOrderedProducts(cart.getProductList());
        cart.getProductList().add(cart.getProductList().get(0));
        Logger.getLogger(CartController.class.getName()).log(Level.INFO, "Product list is  " +cart.getProductList());
        order.setOrderedServices(cart.getServiceList());
        User user = (User) request.getSession().getAttribute("user");
        List<Order> userOrders = user.getOrders();
        if(userOrders == null){
            user.setOrders(new ArrayList<>());
        }
        user.getOrders().add(order);
        user.update();
        return false;
    }
}
