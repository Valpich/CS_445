package iit.cs445.controllers.product.securityCamera;

import iit.cs445.models.products.AnalogSurveillanceCamera;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AnalogSurveillanceCameraController {

    @RequestMapping(value = "/product/surveillance-camera/analog", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<AnalogSurveillanceCamera> list = new AnalogSurveillanceCamera().listAll();
        model.addAttribute("analogSurveillanceCameras", list);
        return "product";
    }

}
