package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.InfraredLightning;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class InfraredLightningController {

    @RequestMapping(value = "/product/accessory/infrared-lightning", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<InfraredLightning> list = new InfraredLightning().listAll();
        model.addAttribute("infraredLightnings", list);
        return "product";
    }

}
