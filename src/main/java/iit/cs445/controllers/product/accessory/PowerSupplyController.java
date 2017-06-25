package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.PowerSupply;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PowerSupplyController {

    @RequestMapping(value = "/product/accessory/power-supply", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<PowerSupply> list = new PowerSupply().listAll();
        model.addAttribute("powerSupplies", list);
        return "product";
    }

}
