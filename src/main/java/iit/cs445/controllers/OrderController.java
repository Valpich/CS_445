package iit.cs445.controllers;

import iit.cs445.models.orders.Order;
import iit.cs445.models.orders.OrderStatus;
import iit.cs445.models.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {

    @RequestMapping(value = "/order/list", method = RequestMethod.GET)
    public String list(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<Order> orders = user.getOrders();
        request.setAttribute("orders", orders);
        return "orders/list";
    }

    @RequestMapping(value = "/order/listAll", method = RequestMethod.GET)
    public String listAll(HttpServletRequest request) {
        List<Order> orders = new Order().listAll();
        request.setAttribute("orders", orders);
        return "orders/listAll";
    }

    @RequestMapping(value = "/order/update/{id}/{status}", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable("id") Long id, @PathVariable String status) {
        Order order = new Order().findById(id);
        switch (status) {
            case "DELIVERED":
                order.setStatus(OrderStatus.DELIVERED);
                order.update();
                break;
            case "PREPARING_SHIPPING":
                order.setStatus(OrderStatus.PREPARING_SHIPPING);
                order.update();
                break;
            case "PROCESSING":
                order.setStatus(OrderStatus.PROCESSING);
                order.update();
                break;
            case "SHIPPED":
                order.setStatus(OrderStatus.SHIPPED);
                order.update();
                break;
            default:
                break;
        }
        return "redirect:/order/listAll";
    }
}
