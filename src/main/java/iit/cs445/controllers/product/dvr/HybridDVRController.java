package iit.cs445.controllers.product.dvr;

import iit.cs445.models.products.HybridDVR;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HybridDVRController {

    @RequestMapping(value = "/product/dvr/hybrid", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<HybridDVR> list = new HybridDVR().listAll();
        model.addAttribute("hybridsDVR", list);
        return "product";
    }

}
