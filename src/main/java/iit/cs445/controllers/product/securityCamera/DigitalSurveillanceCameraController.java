package iit.cs445.controllers.product.securityCamera;

import iit.cs445.models.products.DigitalSurveillanceCamera;
import iit.cs445.models.products.IPSurveillanceCamera;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DigitalSurveillanceCameraController {

    @RequestMapping(value = "/product/surveillance-camera/digital", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<DigitalSurveillanceCamera> list = new DigitalSurveillanceCamera().listAll();
        model.addAttribute("digitalSurveillanceCameras", list);
        return "product";
    }

    @RequestMapping(value = "/product/securityCamera/digitalSurveillanceCamera/add", method = RequestMethod.GET)
    public String showAddIpSurveillanceCameraForm(Model model) {
        DigitalSurveillanceCamera digitalSurveillanceCamera = new DigitalSurveillanceCamera();
        model.addAttribute("digitalSurveillanceCameraForm", digitalSurveillanceCamera);
        return "productForm";
    }

    @RequestMapping(value = "/digitalSurveillanceCamera", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description ,
                               @RequestParam("resolution") String resolution ,
                               @RequestParam("price") String price ) {
        saveDigitalSurveillanceCamera(description, resolution, price);
        return "index";
    }

    private void saveDigitalSurveillanceCamera(String description, String resolution, String price) {
        DigitalSurveillanceCamera digitalSurveillanceCamera = new DigitalSurveillanceCamera();
        digitalSurveillanceCamera.setPrice(Float.parseFloat(price));
        digitalSurveillanceCamera.setResolution(resolution);
        digitalSurveillanceCamera.setDescription(description);
        digitalSurveillanceCamera.saveNew();
    }

}
