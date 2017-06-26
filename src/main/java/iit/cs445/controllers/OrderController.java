package iit.cs445.controllers;

import iit.cs445.models.orders.Order;
import iit.cs445.models.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {

    @RequestMapping(value = "/order/listAll", method = RequestMethod.GET)
    public String listAll(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<Order> orders = user.getOrders();
        request.setAttribute("orders",orders);
        return "orders/list";
    }

}
