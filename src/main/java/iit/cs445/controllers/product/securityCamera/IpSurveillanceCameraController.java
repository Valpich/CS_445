package iit.cs445.controllers.product.securityCamera;

import iit.cs445.models.products.IPSurveillanceCamera;
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

    @RequestMapping(value = "/ipSurveillanceCamera/{id}/delete", method = RequestMethod.GET)
    public String deleteIpSurveillanceCamera(@PathVariable("id") Long id, Model model) {
        IPSurveillanceCamera ipSurveillanceCamera = new IPSurveillanceCamera().findById(id);
        ipSurveillanceCamera.setDeleted(true);
        ipSurveillanceCamera.update();
        model.addAttribute("ipSurveillanceCameraForm", ipSurveillanceCamera);
        return "index";
    }

    @RequestMapping(value = "/ipSurveillanceCamera", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("resolution") String resolution,
                               @RequestParam("price") String price) {
        saveIpSurveillanceCamera(description, resolution, price);
        return "index";
    }

    @RequestMapping(value = "/ipSurveillanceCamera/{id}/cart", method = RequestMethod.GET)
    public String addIpSurveillanceCameraToCart(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        IPSurveillanceCamera ipSurveillanceCamera = new IPSurveillanceCamera().findById(id);
        saveCart(request, ipSurveillanceCamera);
        model.addAttribute("ipSurveillanceCamera", ipSurveillanceCamera);
        return "index";
    }

    private boolean saveCart(HttpServletRequest request, IPSurveillanceCamera ipSurveillanceCamera) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.add(ipSurveillanceCamera);
        return true;
    }

    @RequestMapping(value = "/ipSurveillanceCameraUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                               @RequestParam("description") String description,
                               @RequestParam("resolution") String resolution,
                               @RequestParam("price") String price) {
        updateIpSurveillanceCamera(id, description, resolution, price);
        return "index";
    }

    private void saveIpSurveillanceCamera(String description, String resolution, String price) {
        IPSurveillanceCamera ipSurveillanceCamera = new IPSurveillanceCamera();
        ipSurveillanceCamera.setPrice(Float.parseFloat(price));
        ipSurveillanceCamera.setResolution(resolution);
        ipSurveillanceCamera.setDescription(description);
        ipSurveillanceCamera.setDeleted(false);
        ipSurveillanceCamera.saveNew();
    }

    private void updateIpSurveillanceCamera(String id, String description, String resolution, String price) {
        IPSurveillanceCamera ipSurveillanceCameraOld = new IPSurveillanceCamera().findById(Long.parseLong(id));
        ipSurveillanceCameraOld.setDeleted(true);
        ipSurveillanceCameraOld.update();

        IPSurveillanceCamera ipSurveillanceCamera = new IPSurveillanceCamera();
        ipSurveillanceCamera.setPrice(Float.parseFloat(price));
        ipSurveillanceCamera.setResolution(resolution);
        ipSurveillanceCamera.setDescription(description);
        ipSurveillanceCamera.setDeleted(false);
        ipSurveillanceCamera.saveNew();
    }

}
