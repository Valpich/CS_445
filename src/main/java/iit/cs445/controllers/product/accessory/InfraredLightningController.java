package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.InfraredLightning;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class InfraredLightningController {

    @RequestMapping(value = "/product/accessory/infrared-lightning", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<InfraredLightning> list = new InfraredLightning().listAll();
        model.addAttribute("infraredLightnings", list);
        return "product";
    }

    @RequestMapping(value = "/product/accessory/infraredLightning/add", method = RequestMethod.GET)
    public String showInfraredLightningForm(Model model) {
        InfraredLightning infraredLightning = new InfraredLightning();
        model.addAttribute("infraredLightningForm", infraredLightning);
        return "productForm";
    }

    @RequestMapping(value = "/infraredLightning", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description ,
                               @RequestParam("price") String price ) {
        saveInfraredLightninh(description, price);
        return "index";
    }

    private void saveInfraredLightninh(String description, String price) {
        InfraredLightning infraredLightning = new InfraredLightning();
        infraredLightning.setPrice(Float.parseFloat(price));
        infraredLightning.setDescription(description);
        infraredLightning.saveNew();
    }

}
