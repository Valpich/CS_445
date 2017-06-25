package iit.cs445.controllers.product.securityCamera;

import iit.cs445.models.products.IPSurveillanceCamera;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IpSurveillanceCameraController {

    @RequestMapping(value = "/product/surveillance-camera/ip", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<IPSurveillanceCamera> list = new IPSurveillanceCamera().listAll();
        model.addAttribute("ipSurveillanceCameras", list);
        return "product";
    }

}
