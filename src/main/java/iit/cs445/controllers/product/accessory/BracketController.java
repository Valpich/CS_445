package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.Bracket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/bracket", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("price") String price) {
        saveBracket(description, price);
        return "index";
    }

    private void saveBracket(String description, String price) {
        Bracket bracket = new Bracket();
        bracket.setPrice(Float.parseFloat(price));
        bracket.setDescription(description);
        bracket.saveNew();
    }

}
