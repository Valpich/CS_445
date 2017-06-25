package iit.cs445.controllers.product.securityCamera;

import iit.cs445.models.products.DigitalSurveillanceCamera;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class DigitalSurveillanceCameraController {

    @RequestMapping(value = "/product/surveillance-camera/digital", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<DigitalSurveillanceCamera> list = new DigitalSurveillanceCamera().listAll();
        model.addAttribute("digitalSurveillanceCameras", list);
        return "product";
    }

}
