package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.Microphone;
import iit.cs445.models.products.MicrophoneType;
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
public class MicrophoneController {

    @RequestMapping(value = "/product/accessory/microphone", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Microphone> list = new Microphone().listAll();
        model.addAttribute("microphones", list);
        return "product";
    }

    @RequestMapping(value = "/product/accessory/microphone/add", method = RequestMethod.GET)
    public String showMicrophoneForm(Model model) {
        Microphone microphone = new Microphone();
        model.addAttribute("microphoneForm", microphone);
        return "productForm";
    }

    @RequestMapping(value = "/microphone/{id}/cart", method = RequestMethod.GET)
    public String addMicrophoneToCart(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        Microphone microphone = new Microphone().findById(id);
        saveCart(request, microphone);
        List<Microphone> list = new Microphone().listAll();
        model.addAttribute("microphones", list);
        return "product";
    }

    private boolean saveCart(HttpServletRequest request, Microphone microphone) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.add(microphone);
        return true;
    }

    @RequestMapping(value = "/microphone/{id}/update", method = RequestMethod.GET)
    public String showUpdateMicrophoneForm(@PathVariable("id") Long id, Model model) {
        Microphone microphone = new Microphone().findById(id);
        model.addAttribute("microphoneFormUpdate", microphone);
        return "productForm";
    }

    @RequestMapping(value = "/microphone/{id}/delete", method = RequestMethod.GET)
    public String deleteMicrophone(@PathVariable("id") Long id, Model model) {
        Microphone microphone = new Microphone().findById(id);
        microphone.setDeleted(true);
        microphone.update();
        List<Microphone> list = new Microphone().listAll();
        model.addAttribute("microphones", list);
        return "product";
    }

    @RequestMapping(value = "/microphone", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("battery") Boolean battery,
                               @RequestParam("microphone_type") String microphoneType,
                               @RequestParam("price") String price,
                               Model model) {
        saveMicrophone(description, battery, microphoneType, price);
        List<Microphone> list = new Microphone().listAll();
        model.addAttribute("microphones", list);
        return "product";
    }

    @RequestMapping(value = "/microphoneUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                               @RequestParam("description") String description,
                               @RequestParam("battery") Boolean battery,
                               @RequestParam("microphone_type") String microphoneType,
                               @RequestParam("price") String price,
                               Model model) {
        updateMicrophone(id, description, battery, microphoneType, price);
        List<Microphone> list = new Microphone().listAll();
        model.addAttribute("microphones", list);
        return "product";
    }


    private void saveMicrophone(String description, Boolean battery, String microphoneType, String price) {
        Microphone microphone = new Microphone();
        microphone.setPrice(Float.parseFloat(price));
        microphone.setDescription(description);
        microphone.setBattery(battery);
        if (microphoneType.equals("CONDENSER")) {
            microphone.setMicrophoneType(MicrophoneType.CONDENSER);
        } else if (microphoneType.equals("DYNAMIC")) {
            microphone.setMicrophoneType(MicrophoneType.DYNAMIC);
        } else if (microphoneType.equals("RIBBON")) {
            microphone.setMicrophoneType(MicrophoneType.RIBBON);
        } else if (microphoneType.equals("CARBON")) {
            microphone.setMicrophoneType(MicrophoneType.CARBON);
        } else if (microphoneType.equals("PIEZOELECTRIC")) {
            microphone.setMicrophoneType(MicrophoneType.PIEZOELECTRIC);
        } else if (microphoneType.equals("FIBER_OPTIC")) {
            microphone.setMicrophoneType(MicrophoneType.FIBER_OPTIC);
        } else if (microphoneType.equals("LASER")) {
            microphone.setMicrophoneType(MicrophoneType.LASER);
        } else if (microphoneType.equals("LIQUID")) {
            microphone.setMicrophoneType(MicrophoneType.LIQUID);
        } else {
            microphone.setMicrophoneType(MicrophoneType.MEMS);
        }
        microphone.setDeleted(false);
        microphone.saveNew();
    }

    private void updateMicrophone(String id, String description, Boolean battery, String microphoneType, String price) {
        Microphone microphoneOld = new Microphone().findById(Long.parseLong(id));
        microphoneOld.setDeleted(true);
        microphoneOld.update();

        Microphone microphone = new Microphone();
        microphone.setPrice(Float.parseFloat(price));
        microphone.setDescription(description);
        microphone.setBattery(battery);
        if (microphoneType.equals("CONDENSER")) {
            microphone.setMicrophoneType(MicrophoneType.CONDENSER);
        } else if (microphoneType.equals("DYNAMIC")) {
            microphone.setMicrophoneType(MicrophoneType.DYNAMIC);
        } else if (microphoneType.equals("RIBBON")) {
            microphone.setMicrophoneType(MicrophoneType.RIBBON);
        } else if (microphoneType.equals("CARBON")) {
            microphone.setMicrophoneType(MicrophoneType.CARBON);
        } else if (microphoneType.equals("PIEZOELECTRIC")) {
            microphone.setMicrophoneType(MicrophoneType.PIEZOELECTRIC);
        } else if (microphoneType.equals("FIBER_OPTIC")) {
            microphone.setMicrophoneType(MicrophoneType.FIBER_OPTIC);
        } else if (microphoneType.equals("LASER")) {
            microphone.setMicrophoneType(MicrophoneType.LASER);
        } else if (microphoneType.equals("LIQUID")) {
            microphone.setMicrophoneType(MicrophoneType.LIQUID);
        } else {
            microphone.setMicrophoneType(MicrophoneType.MEMS);
        }
        microphone.setDeleted(false);
        microphone.saveNew();
    }

}
