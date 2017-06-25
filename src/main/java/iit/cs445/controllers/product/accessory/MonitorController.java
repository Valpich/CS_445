package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.Bracket;
import iit.cs445.models.products.Monitor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MonitorController {

    @RequestMapping(value = "/product/accessory/monitor", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Monitor> list = new Monitor().listAll();
        model.addAttribute("monitors", list);
        return "product";
    }

}
