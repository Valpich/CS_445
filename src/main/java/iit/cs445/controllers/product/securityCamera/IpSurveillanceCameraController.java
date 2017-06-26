package iit.cs445.controllers.product.securityCamera;

import iit.cs445.models.products.IPSurveillanceCamera;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IpSurveillanceCameraController {

    @RequestMapping(value = "/product/surveillance-camera/ip", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<IPSurveillanceCamera> list = new IPSurveillanceCamera().listAll();
        model.addAttribute("ipSurveillanceCameras", list);
        return "product";
    }

    @RequestMapping(value = "/product/securityCamera/ipSurveillanceCamera/add", method = RequestMethod.GET)
    public String showAddIpSurveillanceCameraForm(Model model) {
        IPSurveillanceCamera ipSurveillanceCamera = new IPSurveillanceCamera();
        model.addAttribute("ipSurveillanceCameraForm", ipSurveillanceCamera);
        return "productForm";
    }

    @RequestMapping(value = "/ipSurveillanceCamera/{id}/update", method = RequestMethod.GET)
    public String showUpdateIpSurveillanceCameraForm(@PathVariable("id") Long id, Model model) {
        IPSurveillanceCamera ipSurveillanceCamera = new IPSurveillanceCamera().findById(id);
        model.addAttribute("ipSurveillanceCameraFormUpdate", ipSurveillanceCamera);
        return "productForm";
    }

    @RequestMapping(value = "/ipSurveillanceCamera", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description ,
                               @RequestParam("resolution") String resolution ,
                               @RequestParam("price") String price ) {
        saveIpSurveillanceCamera(description, resolution, price);
        return "index";
    }

    private void saveIpSurveillanceCamera(String description, String resolution, String price) {
        IPSurveillanceCamera ipSurveillanceCamera = new IPSurveillanceCamera();
        ipSurveillanceCamera.setPrice(Float.parseFloat(price));
        ipSurveillanceCamera.setResolution(resolution);
        ipSurveillanceCamera.setDescription(description);
        ipSurveillanceCamera.saveNew();
    }

}
