package iit.cs445.controllers.service;

import iit.cs445.models.services.SurveillanceDesign;
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
public class SurveillanceDesignController {

    @RequestMapping(value = "/service/surveillance-design", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<SurveillanceDesign> list = new SurveillanceDesign().listAll();
        model.addAttribute("surveillanceDesigns", list);
        return "service";
    }

    @RequestMapping(value = "/service/surveillanceDesign/add", method = RequestMethod.GET)
    public String showSurveillanceDesignForm(Model model) {
        SurveillanceDesign surveillanceDesign = new SurveillanceDesign();
        model.addAttribute("surveillanceDesignForm", surveillanceDesign);
        return "serviceForm";
    }

    @RequestMapping(value = "/surveillanceDesign/{id}/cart", method = RequestMethod.GET)
    public String addSurveillanceDesignToCart(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        SurveillanceDesign surveillanceDesign = new SurveillanceDesign().findById(id);
        saveCart(request, surveillanceDesign);
        model.addAttribute("surveillanceDesign", surveillanceDesign);
        return "index";
    }

    private boolean saveCart(HttpServletRequest request, SurveillanceDesign surveillanceDesign) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.add(surveillanceDesign);
        return true;
    }

    @RequestMapping(value = "/surveillanceDesign/{id}/update", method = RequestMethod.GET)
    public String showUpdateSurveillanceDesignForm(@PathVariable("id") Long id, Model model) {
        SurveillanceDesign surveillanceDesign = new SurveillanceDesign().findById(id);
        model.addAttribute("surveillanceDesignFormUpdate", surveillanceDesign);
        return "serviceForm";
    }

    @RequestMapping(value = "/surveillanceDesign/{id}/delete", method = RequestMethod.GET)
    public String deleteSurveillanceDesign(@PathVariable("id") Long id, Model model) {
        SurveillanceDesign surveillanceDesign = new SurveillanceDesign().findById(id);
        surveillanceDesign.setDeleted(true);
        surveillanceDesign.update();
        model.addAttribute("surveillanceDesignForm", surveillanceDesign);
        return "index";
    }

    @RequestMapping(value = "/surveillanceDesign", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("price") String price) {
        saveSurveillanceDesign(description, price);
        return "index";
    }

    @RequestMapping(value = "/surveillanceDesignUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                               @RequestParam("description") String description,
                               @RequestParam("price") String price) {
        updateSurveillanceDesign(id, description, price);
        return "index";
    }

    private void saveSurveillanceDesign(String description, String price) {
        SurveillanceDesign surveillanceDesign = new SurveillanceDesign();
        surveillanceDesign.setPrice(Float.parseFloat(price));
        surveillanceDesign.setDescription(description);
        surveillanceDesign.setDeleted(false);
        surveillanceDesign.saveNew();
    }

    private void updateSurveillanceDesign(String id, String description, String price) {
        SurveillanceDesign surveillanceDesignOld = new SurveillanceDesign().findById(Long.parseLong(id));
        surveillanceDesignOld.setDeleted(true);
        surveillanceDesignOld.update();

        SurveillanceDesign surveillanceDesign = new SurveillanceDesign();
        surveillanceDesign.setPrice(Float.parseFloat(price));
        surveillanceDesign.setDescription(description);
        surveillanceDesign.setDeleted(false);
        surveillanceDesign.saveNew();
    }

}
