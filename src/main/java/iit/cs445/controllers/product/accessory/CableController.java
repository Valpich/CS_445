package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.Cable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CableController {

    @RequestMapping(value = "/product/accessory/cable", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Cable> list = new Cable().listAll();
        model.addAttribute("cables", list);
        return "product";
    }

}
