package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.Bracket;
import iit.cs445.models.products.Connector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ConnectorController {

    @RequestMapping(value = "/product/accessory/connector", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Connector> list = new Connector().listAll();
        model.addAttribute("conenctors", list);
        return "product";
    }

}
