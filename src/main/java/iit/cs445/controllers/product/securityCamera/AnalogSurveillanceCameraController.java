package iit.cs445.controllers.product.securityCamera;

import iit.cs445.models.products.AnalogSurveillanceCamera;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AnalogSurveillanceCameraController {

    @RequestMapping(value = "/product/surveillance-camera/analog", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<AnalogSurveillanceCamera> list = new AnalogSurveillanceCamera().listAll();
        model.addAttribute("analogSurveillanceCameras", list);
        return "product";
    }

    @RequestMapping(value = "/product/securityCamera/analogSurveillanceCamera/add", method = RequestMethod.GET)
    public String showAddAnalogSurveillanceCameraForm(Model model) {
        AnalogSurveillanceCamera analogSurveillanceCamera = new AnalogSurveillanceCamera();
        model.addAttribute("analogSurveillanceCameraForm", analogSurveillanceCamera);
        return "productForm";
    }

    @RequestMapping(value = "/analogSurveillanceCamera/{id}/update", method = RequestMethod.GET)
    public String showUpdateAnalogSurveillanceCameraForm(@PathVariable("id") Long id, Model model) {
        AnalogSurveillanceCamera analogSurveillanceCamera = new AnalogSurveillanceCamera();
        model.addAttribute("analogSurveillanceCameraFormUpdate", analogSurveillanceCamera);
        return "productForm";
    }

    @RequestMapping(value = "/analogSurveillanceCamera", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("resolution") String resolution,
                               @RequestParam("price") String price) {
        saveAnalogSurveillanceCamera(description, resolution, price);
        return "index";
    }

    private void saveAnalogSurveillanceCamera(String description, String resolution, String price) {
        AnalogSurveillanceCamera analogSurveillanceCamera = new AnalogSurveillanceCamera();
        analogSurveillanceCamera.setPrice(Float.parseFloat(price));
        analogSurveillanceCamera.setResolution(resolution);
        analogSurveillanceCamera.setDescription(description);
        analogSurveillanceCamera.saveNew();
    }

}
