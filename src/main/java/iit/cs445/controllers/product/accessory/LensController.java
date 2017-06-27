package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.Lens;
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
public class LensController {

    @RequestMapping(value = "/product/accessory/lens", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Lens> list = new Lens().listAll();
        model.addAttribute("lenses", list);
        return "product";
    }

    @RequestMapping(value = "/product/accessory/lens/add", method = RequestMethod.GET)
    public String showLensForm(Model model) {
        Lens lens = new Lens();
        model.addAttribute("lensForm", lens);
        return "productForm";
    }

    @RequestMapping(value = "/lens/{id}/cart", method = RequestMethod.GET)
    public String addLensToCart(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        Lens lens = new Lens().findById(id);
        saveCart(request, lens);
        model.addAttribute("lens", lens);
        return "index";
    }

    private boolean saveCart(HttpServletRequest request, Lens lens) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.add(lens);
        return true;
    }

    @RequestMapping(value = "/lens/{id}/update", method = RequestMethod.GET)
    public String showUpdateLensForm(@PathVariable("id") Long id, Model model) {
        Lens lens = new Lens().findById(id);
        model.addAttribute("lensFormUpdate", lens);
        return "productForm";
    }

    @RequestMapping(value = "/lens/{id}/delete", method = RequestMethod.GET)
    public String deleteLens(@PathVariable("id") Long id, Model model) {
        Lens lens = new Lens().findById(id);
        lens.setDeleted(true);
        lens.update();
        model.addAttribute("lensForm", lens);
        return "index";
    }

    @RequestMapping(value = "/lens", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("focal") String focal,
                               @RequestParam("magnification") String magnification,
                               @RequestParam("price") String price) {
        saveLens(description, focal, magnification, price);
        return "index";
    }

    @RequestMapping(value = "/lensUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                               @RequestParam("description") String description,
                               @RequestParam("focal") String focal,
                               @RequestParam("magnification") String magnification,
                               @RequestParam("price") String price) {
        updateLens(id, description, focal, magnification, price);
        return "index";
    }


    private void saveLens(String description, String focal, String magnification, String price) {
        Lens lens = new Lens();
        lens.setPrice(Float.parseFloat(price));
        lens.setFocal(Float.parseFloat(focal));
        lens.setMagnification(Float.parseFloat(magnification));
        lens.setDescription(description);
        lens.setDeleted(false);
        lens.saveNew();
    }

    private void updateLens(String id, String description, String focal, String magnification, String price) {
        Lens lensOld = new Lens().findById(Long.parseLong(id));
        lensOld.setDeleted(true);
        lensOld.update();

        Lens lens = new Lens();
        lens.setPrice(Float.parseFloat(price));
        lens.setFocal(Float.parseFloat(focal));
        lens.setMagnification(Float.parseFloat(magnification));
        lens.setDescription(description);
        lens.setDeleted(false);
        lens.saveNew();
    }

}
