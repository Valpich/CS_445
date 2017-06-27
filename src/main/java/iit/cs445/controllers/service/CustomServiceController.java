package iit.cs445.controllers.service;

import iit.cs445.models.services.CustomService;
import iit.cs445.models.users.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CustomServiceController {

    @RequestMapping(value = "/service/custom-service", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<CustomService> list = new CustomService().listAll();
        model.addAttribute("customServices", list);
        return "service";
    }

    @RequestMapping(value = "/service/customService/add", method = RequestMethod.GET)
    public String showCustomServiceForm(Model model) {
        CustomService customService = new CustomService();
        model.addAttribute("customServiceForm", customService);
        return "serviceForm";
    }

    @RequestMapping(value = "/customService/{id}/cart", method = RequestMethod.GET)
    public String addCustomServiceToCart(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        CustomService customService = new CustomService().findById(id);
        saveCart(request, customService);
        model.addAttribute("customService", customService);
        return "index";
    }

    private boolean saveCart(HttpServletRequest request, CustomService customService) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.add(customService);
        return true;
    }

    @RequestMapping(value = "/customService/{id}/update", method = RequestMethod.GET)
    public String showUpdateCustomServiceForm(@PathVariable("id") Long id, Model model) {
        CustomService customService = new CustomService().findById(id);
        model.addAttribute("customServiceFormUpdate", customService);
        return "serviceForm";
    }

    @RequestMapping(value = "/customService/{id}/delete", method = RequestMethod.GET)
    public String deleteCustomService(@PathVariable("id") Long id, Model model) {
        CustomService customService = new CustomService().findById(id);
        customService.setDeleted(true);
        customService.update();
        model.addAttribute("customServiceForm", customService);
        return "index";
    }

    @RequestMapping(value = "/customService", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("price") String price) {
        saveCustomService(description, price);
        return "index";
    }

    @RequestMapping(value = "/customServiceUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                               @RequestParam("description") String description,
                               @RequestParam("price") String price) {
        updateCustomService(id, description, price);
        return "index";
    }

    private void saveCustomService(String description, String price) {
        CustomService customService = new CustomService();
        customService.setPrice(Float.parseFloat(price));
        customService.setDescription(description);
        customService.setDeleted(false);
        customService.saveNew();
    }

    private void updateCustomService(String id, String description, String price) {
        CustomService customServiceOld = new CustomService().findById(Long.parseLong(id));
        customServiceOld.setDeleted(true);
        customServiceOld.update();

        CustomService customService = new CustomService();
        customService.setPrice(Float.parseFloat(price));
        customService.setDescription(description);
        customService.setDeleted(false);
        customService.saveNew();
    }

}
