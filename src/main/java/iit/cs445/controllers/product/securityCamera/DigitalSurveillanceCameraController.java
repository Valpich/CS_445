package iit.cs445.controllers.product.securityCamera;

import iit.cs445.models.products.DigitalSurveillanceCamera;
import iit.cs445.models.users.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/digitalSurveillanceCamera/{id}/cart", method = RequestMethod.GET)
    public String addDigitalSurveillanceCameraToCart(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        DigitalSurveillanceCamera digitalSurveillanceCamera = new DigitalSurveillanceCamera().findById(id);
        saveCart(request, digitalSurveillanceCamera);
        model.addAttribute("digitalSurveillanceCamera", digitalSurveillanceCamera);
        return "index";
    }

    private boolean saveCart(HttpServletRequest request, DigitalSurveillanceCamera digitalSurveillanceCamera) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.add(digitalSurveillanceCamera);
        return true;
    }

    @RequestMapping(value = "/digitalSurveillanceCamera/{id}/update", method = RequestMethod.GET)
    public String showUpdateDigitalSurveillanceCameraForm(@PathVariable("id") Long id, Model model) {
        DigitalSurveillanceCamera digitalSurveillanceCamera = new DigitalSurveillanceCamera().findById(id);
        model.addAttribute("digitalSurveillanceCameraFormUpdate", digitalSurveillanceCamera);
        return "productForm";
    }

    @RequestMapping(value = "/digitalSurveillanceCamera/{id}/delete", method = RequestMethod.GET)
    public String deleteDigitalSurveillanceCamera(@PathVariable("id") Long id, Model model) {
        DigitalSurveillanceCamera digitalSurveillanceCamera = new DigitalSurveillanceCamera().findById(id);
        digitalSurveillanceCamera.setDeleted(true);
        digitalSurveillanceCamera.update();
        model.addAttribute("digitalSurveillanceCameraForm", digitalSurveillanceCamera);
        return "index";
    }

    @RequestMapping(value = "/digitalSurveillanceCamera", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("resolution") String resolution,
                               @RequestParam("price") String price) {
        saveDigitalSurveillanceCamera(description, resolution, price);
        return "index";
    }

    @RequestMapping(value = "/digitalSurveillanceCameraUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                               @RequestParam("description") String description,
                               @RequestParam("resolution") String resolution,
                               @RequestParam("price") String price) {
        updateDigitalSurveillanceCamera(id, description, resolution, price);
        return "index";
    }

    private void saveDigitalSurveillanceCamera(String description, String resolution, String price) {
        DigitalSurveillanceCamera digitalSurveillanceCamera = new DigitalSurveillanceCamera();
        digitalSurveillanceCamera.setPrice(Float.parseFloat(price));
        digitalSurveillanceCamera.setResolution(resolution);
        digitalSurveillanceCamera.setDescription(description);
        digitalSurveillanceCamera.setDeleted(false);
        digitalSurveillanceCamera.saveNew();
    }

    private void updateDigitalSurveillanceCamera(String id, String description, String resolution, String price) {
        DigitalSurveillanceCamera digitalSurveillanceCameraOld = new DigitalSurveillanceCamera().findById(Long.parseLong(id));
        digitalSurveillanceCameraOld.setDeleted(true);
        digitalSurveillanceCameraOld.update();

        DigitalSurveillanceCamera digitalSurveillanceCamera = new DigitalSurveillanceCamera();
        digitalSurveillanceCamera.setPrice(Float.parseFloat(price));
        digitalSurveillanceCamera.setResolution(resolution);
        digitalSurveillanceCamera.setDescription(description);
        digitalSurveillanceCamera.setDeleted(false);
        digitalSurveillanceCamera.saveNew();
    }

}
