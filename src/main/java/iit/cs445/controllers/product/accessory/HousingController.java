package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.Housing;
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
public class HousingController {

    @RequestMapping(value = "/product/accessory/housing", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Housing> list = new Housing().listAll();
        model.addAttribute("housings", list);
        return "product";
    }

    @RequestMapping(value = "/product/accessory/housing/add", method = RequestMethod.GET)
    public String showHousingForm(Model model) {
        Housing housing = new Housing();
        model.addAttribute("housingForm", housing);
        return "productForm";
    }

    @RequestMapping(value = "/housing/{id}/cart", method = RequestMethod.GET)
    public String addHousingToCart(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        Housing housing = new Housing().findById(id);
        saveCart(request, housing);
        List<Housing> list = new Housing().listAll();
        model.addAttribute("housings", list);
        return "product";
    }

    private boolean saveCart(HttpServletRequest request, Housing housing) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.add(housing);
        return true;
    }

    @RequestMapping(value = "/housing/{id}/update", method = RequestMethod.GET)
    public String showUpdateHousingForm(@PathVariable("id") Long id, Model model) {
        Housing housing = new Housing().findById(id);
        model.addAttribute("housingFormUpdate", housing);
        return "productForm";
    }

    @RequestMapping(value = "/housing/{id}/delete", method = RequestMethod.GET)
    public String deketeHousing(@PathVariable("id") Long id, Model model) {
        Housing housing = new Housing().findById(id);
        housing.setDeleted(true);
        housing.update();
        List<Housing> list = new Housing().listAll();
        model.addAttribute("housings", list);
        return "product";
    }

    @RequestMapping(value = "/housing", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("price") String price,
                               Model model) {
        saveHousing(description, price);
        List<Housing> list = new Housing().listAll();
        model.addAttribute("housings", list);
        return "product";
    }

    @RequestMapping(value = "/housingUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                               @RequestParam("description") String description,
                               @RequestParam("price") String price,
                               Model model) {
        updateHousing(id, description, price);
        List<Housing> list = new Housing().listAll();
        model.addAttribute("housings", list);
        return "product";
    }

    private void saveHousing(String description, String price) {
        Housing housing = new Housing();
        housing.setPrice(Float.parseFloat(price));
        housing.setDescription(description);
        housing.setDeleted(false);
        housing.saveNew();
    }

    private void updateHousing(String id, String description, String price) {
        Housing housingOld = new Housing().findById(Long.parseLong(id));
        housingOld.setDeleted(true);
        housingOld.update();

        Housing housing = new Housing();
        housing.setPrice(Float.parseFloat(price));
        housing.setDescription(description);
        housing.setDeleted(false);
        housing.saveNew();
    }

}
