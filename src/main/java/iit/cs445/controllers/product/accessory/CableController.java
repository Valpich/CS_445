package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.Cable;
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
public class CableController {

    @RequestMapping(value = "/product/accessory/cable", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Cable> list = new Cable().listAll();
        model.addAttribute("cables", list);
        return "product";
    }

    @RequestMapping(value = "/product/accessory/cable/add", method = RequestMethod.GET)
    public String showCableForm(Model model) {
        Cable cable = new Cable();
        model.addAttribute("cableForm", cable);
        return "productForm";
    }

    @RequestMapping(value = "/cable/{id}/cart", method = RequestMethod.GET)
    public String addCableToCart(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        Cable cable = new Cable().findById(id);
        saveCart(request, cable);
        List<Cable> list = new Cable().listAll();
        model.addAttribute("cables", list);
        return "product";
    }

    private boolean saveCart(HttpServletRequest request, Cable cable) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.add(cable);
        return true;
    }

    @RequestMapping(value = "/cable/{id}/update", method = RequestMethod.GET)
    public String showUpdateCableForm(@PathVariable("id") Long id, Model model) {
        Cable cable = new Cable().findById(id);
        model.addAttribute("cableFormUpdate", cable);
        return "productForm";
    }

    @RequestMapping(value = "/cable/{id}/delete", method = RequestMethod.GET)
    public String deleteCable(@PathVariable("id") Long id, Model model) {
        Cable cable = new Cable().findById(id);
        cable.setDeleted(true);
        cable.update();
        List<Cable> list = new Cable().listAll();
        model.addAttribute("cables", list);
        return "product";
    }

    @RequestMapping(value = "/cable", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("length") String length,
                               @RequestParam("price") String price,
                               Model model) {
        saveCable(description, length, price);
        List<Cable> list = new Cable().listAll();
        model.addAttribute("cables", list);
        return "product";
    }

    @RequestMapping(value = "/cableUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                               @RequestParam("description") String description,
                               @RequestParam("length") String length,
                               @RequestParam("price") String price,
                               Model model) {
        updateCable(id, description, length, price);
        List<Cable> list = new Cable().listAll();
        model.addAttribute("cables", list);
        return "product";
    }

    private void saveCable(String description, String length, String price) {
        Cable cable = new Cable();
        cable.setPrice(Float.parseFloat(price));
        cable.setLength(Float.parseFloat(length));
        cable.setDescription(description);
        cable.setDeleted(false);
        cable.saveNew();
    }

    private void updateCable(String id, String description, String length, String price) {
        Cable cableOld = new Cable().findById(Long.parseLong(id));
        cableOld.setDeleted(true);
        cableOld.update();

        Cable cable = new Cable();
        cable.setPrice(Float.parseFloat(price));
        cable.setLength(Float.parseFloat(length));
        cable.setDescription(description);
        cable.setDeleted(false);
        cable.saveNew();
    }

}
