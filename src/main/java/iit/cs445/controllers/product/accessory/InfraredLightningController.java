package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.InfraredLightning;
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
public class InfraredLightningController {

    @RequestMapping(value = "/product/accessory/infrared-lightning", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<InfraredLightning> list = new InfraredLightning().listAll();
        model.addAttribute("infraredLightnings", list);
        return "product";
    }

    @RequestMapping(value = "/product/accessory/infraredLightning/add", method = RequestMethod.GET)
    public String showInfraredLightningForm(Model model) {
        InfraredLightning infraredLightning = new InfraredLightning();
        model.addAttribute("infraredLightningForm", infraredLightning);
        return "productForm";
    }

    @RequestMapping(value = "/infraredLightning/{id}/cart", method = RequestMethod.GET)
    public String addInfraredLightningToCart(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        InfraredLightning infraredLightning = new InfraredLightning().findById(id);
        saveCart(request, infraredLightning);
        model.addAttribute("bracket", infraredLightning);
        return "index";
    }

    private boolean saveCart(HttpServletRequest request, InfraredLightning infraredLightning) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.add(infraredLightning);
        return true;
    }

    @RequestMapping(value = "/infraredLightning/{id}/update", method = RequestMethod.GET)
    public String showUpdateInfraredLightningForm(@PathVariable("id") Long id, Model model) {
        InfraredLightning infraredLightning = new InfraredLightning().findById(id);
        model.addAttribute("infraredLightningFormUpdate", infraredLightning);
        return "productForm";
    }

    @RequestMapping(value = "/infraredLightning/{id}/delete", method = RequestMethod.GET)
    public String deleteInfraredLightning(@PathVariable("id") Long id, Model model) {
        InfraredLightning infraredLightning = new InfraredLightning().findById(id);
        infraredLightning.setDeleted(true);
        infraredLightning.update();
        model.addAttribute("infraredLightningForm", infraredLightning);
        return "index";
    }

    @RequestMapping(value = "/infraredLightning", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("price") String price) {
        saveInfraredLightning(description, price);
        return "index";
    }

    @RequestMapping(value = "/infraredLightningUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                               @RequestParam("description") String description,
                               @RequestParam("price") String price) {
        updateInfraredLightning(id, description, price);
        return "index";
    }

    private void saveInfraredLightning(String description, String price) {
        InfraredLightning infraredLightning = new InfraredLightning();
        infraredLightning.setPrice(Float.parseFloat(price));
        infraredLightning.setDescription(description);
        infraredLightning.setDeleted(false);
        infraredLightning.saveNew();
    }

    private void updateInfraredLightning(String id, String description, String price) {
        InfraredLightning infraredLightningOld = new InfraredLightning().findById(Long.parseLong(id));
        infraredLightningOld.setDeleted(true);
        infraredLightningOld.update();

        InfraredLightning infraredLightning = new InfraredLightning();
        infraredLightning.setPrice(Float.parseFloat(price));
        infraredLightning.setDescription(description);
        infraredLightning.setDeleted(false);
        infraredLightning.saveNew();
    }

}
