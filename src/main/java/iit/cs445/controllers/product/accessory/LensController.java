package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.Lens;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class LensController {

    @RequestMapping(value = "/product/accessory/lens", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Lens> list = new Lens().listAll();
        model.addAttribute("lenses", list);
        return "product";
    }

}
