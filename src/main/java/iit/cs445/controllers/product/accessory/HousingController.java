package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.Housing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HousingController {

    @RequestMapping(value = "/product/accessory/housing", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Housing> list = new Housing().listAll();
        model.addAttribute("housings", list);
        return "product";
    }

}