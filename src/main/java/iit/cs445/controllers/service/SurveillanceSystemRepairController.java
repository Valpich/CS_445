package iit.cs445.controllers.service;

import iit.cs445.models.services.SurveillanceSystemRepair;
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
public class SurveillanceSystemRepairController {

    @RequestMapping(value = "/service/surveillance-system-repair", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<SurveillanceSystemRepair> list = new SurveillanceSystemRepair().listAll();
        model.addAttribute("surveillanceSystemRepairs", list);
        return "service";
    }

    @RequestMapping(value = "/service/surveillanceSystemRepair/add", method = RequestMethod.GET)
    public String showSurveillanceSystemRepairForm(Model model) {
        SurveillanceSystemRepair surveillanceSystemRepair = new SurveillanceSystemRepair();
        model.addAttribute("surveillanceSystemRepairForm", surveillanceSystemRepair);
        return "serviceForm";
    }

    @RequestMapping(value = "/surveillanceSystemRepair/{id}/cart", method = RequestMethod.GET)
    public String addSurveillanceSystemRepairToCart(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        SurveillanceSystemRepair surveillanceSystemRepair = new SurveillanceSystemRepair().findById(id);
        saveCart(request, surveillanceSystemRepair);
        List<SurveillanceSystemRepair> list = new SurveillanceSystemRepair().listAll();
        model.addAttribute("surveillanceSystemRepairs", list);
        return "service";
    }

    private boolean saveCart(HttpServletRequest request, SurveillanceSystemRepair surveillanceSystemRepair) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.add(surveillanceSystemRepair);
        return true;
    }

    @RequestMapping(value = "/surveillanceSystemRepair/{id}/update", method = RequestMethod.GET)
    public String showUpdateSurveillanceSystemRepairForm(@PathVariable("id") Long id, Model model) {
        SurveillanceSystemRepair surveillanceSystemRepair = new SurveillanceSystemRepair().findById(id);
        model.addAttribute("surveillanceSystemRepairFormUpdate", surveillanceSystemRepair);
        return "serviceForm";
    }

    @RequestMapping(value = "/surveillanceSystemRepair/{id}/delete", method = RequestMethod.GET)
    public String deleteSurveillanceSystemRepair(@PathVariable("id") Long id, Model model) {
        SurveillanceSystemRepair surveillanceSystemRepair = new SurveillanceSystemRepair().findById(id);
        surveillanceSystemRepair.setDeleted(true);
        surveillanceSystemRepair.update();
        List<SurveillanceSystemRepair> list = new SurveillanceSystemRepair().listAll();
        model.addAttribute("surveillanceSystemRepairs", list);
        return "service";
    }

    @RequestMapping(value = "/surveillanceSystemRepair", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("price") String price,
                               Model model) {
        saveSurveillanceSystemRepair(description, price);
        List<SurveillanceSystemRepair> list = new SurveillanceSystemRepair().listAll();
        model.addAttribute("surveillanceSystemRepairs", list);
        return "service";
    }

    @RequestMapping(value = "/surveillanceSystemRepairUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                               @RequestParam("description") String description,
                               @RequestParam("price") String price,
                               Model model) {
        updateSurveillanceSystemRepair(id, description, price);
        List<SurveillanceSystemRepair> list = new SurveillanceSystemRepair().listAll();
        model.addAttribute("surveillanceSystemRepairs", list);
        return "service";
    }

    private void saveSurveillanceSystemRepair(String description, String price) {
        SurveillanceSystemRepair surveillanceSystemRepair = new SurveillanceSystemRepair();
        surveillanceSystemRepair.setPrice(Float.parseFloat(price));
        surveillanceSystemRepair.setDescription(description);
        surveillanceSystemRepair.setDeleted(false);
        surveillanceSystemRepair.saveNew();
    }

    private void updateSurveillanceSystemRepair(String id, String description, String price) {
        SurveillanceSystemRepair surveillanceSystemRepairOld = new SurveillanceSystemRepair().findById(Long.parseLong(id));
        surveillanceSystemRepairOld.setDeleted(true);
        surveillanceSystemRepairOld.update();

        SurveillanceSystemRepair surveillanceSystemRepair = new SurveillanceSystemRepair();
        surveillanceSystemRepair.setPrice(Float.parseFloat(price));
        surveillanceSystemRepair.setDescription(description);
        surveillanceSystemRepair.setDeleted(false);
        surveillanceSystemRepair.saveNew();
    }

}
