package iit.cs445.controllers.product.dvr;

import iit.cs445.models.products.AnalogDVR;
import iit.cs445.models.products.DigitalDVR;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class DigitalDVRController {

    @RequestMapping(value = "/product/dvr/digital", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<DigitalDVR> list = new DigitalDVR().listAll();
        model.addAttribute("digitalsDVR", list);
        return "product";
    }

}
