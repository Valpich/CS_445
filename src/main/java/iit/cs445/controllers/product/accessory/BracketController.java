package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.Bracket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BracketController {

    @RequestMapping(value = "/product/accessory/bracket", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Bracket> list = new Bracket().listAll();
        model.addAttribute("brackets", list);
        return "product";
    }

}
