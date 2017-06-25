package iit.cs445.controllers.product.dvr;

import iit.cs445.models.products.AnalogDVR;
import iit.cs445.models.users.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AnalogDVRController {

    @RequestMapping(value = "/product/dvr/analog", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<AnalogDVR> list = new AnalogDVR().listAll();
        model.addAttribute("analogsDVR", list);
        return "product";
    }

}
