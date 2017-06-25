package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.Microphone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MicrophoneController {

    @RequestMapping(value = "/product/accessory/microphone", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Microphone> list = new Microphone().listAll();
        model.addAttribute("microphones", list);
        return "product";
    }

}
