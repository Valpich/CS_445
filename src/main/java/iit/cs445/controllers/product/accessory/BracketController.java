package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.Bracket;
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
public class BracketController {

    @RequestMapping(value = "/product/accessory/bracket", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Bracket> list = new Bracket().listAll();
        model.addAttribute("brackets", list);
        return "product";
    }

    @RequestMapping(value = "/product/accessory/bracket/add", method = RequestMethod.GET)
    public String showBracketForm(Model model) {
        Bracket bracket = new Bracket();
        model.addAttribute("bracketForm", bracket);
        return "productForm";
    }

    @RequestMapping(value = "/bracket/{id}/cart", method = RequestMethod.GET)
    public String addBracketToCart(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        Bracket bracket = new Bracket().findById(id);
        saveCart(request, bracket);
        model.addAttribute("bracket", bracket);
        return "index";
    }

    private boolean saveCart(HttpServletRequest request, Bracket bracket) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.add(bracket);
        return true;
    }

    @RequestMapping(value = "/bracket/{id}/update", method = RequestMethod.GET)
    public String showUpdateBracketForm(@PathVariable("id") Long id, Model model) {
        Bracket bracket = new Bracket().findById(id);
        model.addAttribute("bracketFormUpdate", bracket);
        return "productForm";
    }

    @RequestMapping(value = "/bracket/{id}/delete", method = RequestMethod.GET)
    public String deleteBracket(@PathVariable("id") Long id, Model model) {
        Bracket bracket = new Bracket().findById(id);
        bracket.setDeleted(true);
        bracket.update();
        model.addAttribute("bracketForm", bracket);
        return "index";
    }

    @RequestMapping(value = "/bracket", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("price") String price) {
        saveBracket(description, price);
        return "index";
    }

    @RequestMapping(value = "/bracketUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                               @RequestParam("description") String description,
                               @RequestParam("price") String price) {
        updateBracket(id, description, price);
        return "index";
    }

    private void saveBracket(String description, String price) {
        Bracket bracket = new Bracket();
        bracket.setPrice(Float.parseFloat(price));
        bracket.setDescription(description);
        bracket.setDeleted(false);
        bracket.saveNew();
    }

    private void updateBracket(String id, String description, String price) {
        Bracket bracketOld = new Bracket().findById(Long.parseLong(id));
        bracketOld.setDeleted(true);
        bracketOld.update();

        Bracket bracket = new Bracket();
        bracket.setPrice(Float.parseFloat(price));
        bracket.setDescription(description);
        bracket.setDeleted(false);
        bracket.saveNew();
    }

}
