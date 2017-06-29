package iit.cs445.controllers.service;

import iit.cs445.models.services.SecuritySystemInstallation;
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
public class SecuritySystemInstallationController {

    @RequestMapping(value = "/service/security-system-installation", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<SecuritySystemInstallation> list = new SecuritySystemInstallation().listAll();
        model.addAttribute("securitySystemInstallations", list);
        return "service";
    }

    @RequestMapping(value = "/service/securitySystemInstallation/add", method = RequestMethod.GET)
    public String showSecuritySystemInstallationForm(Model model) {
        SecuritySystemInstallation securitySystemInstallation = new SecuritySystemInstallation();
        model.addAttribute("securitySystemInstallationForm", securitySystemInstallation);
        return "serviceForm";
    }

    @RequestMapping(value = "/securitySystemInstallation/{id}/cart", method = RequestMethod.GET)
    public String addSecuritySystemInstallationToCart(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        SecuritySystemInstallation securitySystemInstallation = new SecuritySystemInstallation().findById(id);
        saveCart(request, securitySystemInstallation);
        List<SecuritySystemInstallation> list = new SecuritySystemInstallation().listAll();
        model.addAttribute("securitySystemInstallations", list);
        return "service";
    }

    private boolean saveCart(HttpServletRequest request, SecuritySystemInstallation securitySystemInstallation) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.add(securitySystemInstallation);
        return true;
    }

    @RequestMapping(value = "/securitySystemInstallation/{id}/update", method = RequestMethod.GET)
    public String showUpdateSecuritySystemInstallationForm(@PathVariable("id") Long id, Model model) {
        SecuritySystemInstallation securitySystemInstallation = new SecuritySystemInstallation().findById(id);
        model.addAttribute("securitySystemInstallationFormUpdate", securitySystemInstallation);
        return "serviceForm";
    }

    @RequestMapping(value = "/securitySystemInstallation/{id}/delete", method = RequestMethod.GET)
    public String deleteSecuritySystemInstallation(@PathVariable("id") Long id, Model model) {
        SecuritySystemInstallation securitySystemInstallation = new SecuritySystemInstallation().findById(id);
        securitySystemInstallation.setDeleted(true);
        securitySystemInstallation.update();
        List<SecuritySystemInstallation> list = new SecuritySystemInstallation().listAll();
        model.addAttribute("securitySystemInstallations", list);
        return "service";
    }

    @RequestMapping(value = "/securitySystemInstallation", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("price") String price,
                               Model model) {
        saveSecuritySystemInstallation(description, price);
        List<SecuritySystemInstallation> list = new SecuritySystemInstallation().listAll();
        model.addAttribute("securitySystemInstallations", list);
        return "service";
    }

    @RequestMapping(value = "/securitySystemInstallationUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                               @RequestParam("description") String description,
                               @RequestParam("price") String price,
                               Model model) {
        updateSecuritySystemInstallation(id, description, price);
        List<SecuritySystemInstallation> list = new SecuritySystemInstallation().listAll();
        model.addAttribute("securitySystemInstallations", list);
        return "service";
    }

    private void saveSecuritySystemInstallation(String description, String price) {
        SecuritySystemInstallation securitySystemInstallation = new SecuritySystemInstallation();
        securitySystemInstallation.setPrice(Float.parseFloat(price));
        securitySystemInstallation.setDescription(description);
        securitySystemInstallation.setDeleted(false);
        securitySystemInstallation.saveNew();
    }

    private void updateSecuritySystemInstallation(String id, String description, String price) {
        SecuritySystemInstallation securitySystemInstallationOld = new SecuritySystemInstallation().findById(Long.parseLong(id));
        securitySystemInstallationOld.setDeleted(true);
        securitySystemInstallationOld.update();

        SecuritySystemInstallation securitySystemInstallation = new SecuritySystemInstallation();
        securitySystemInstallation.setPrice(Float.parseFloat(price));
        securitySystemInstallation.setDescription(description);
        securitySystemInstallation.setDeleted(false);
        securitySystemInstallation.saveNew();
    }

}
