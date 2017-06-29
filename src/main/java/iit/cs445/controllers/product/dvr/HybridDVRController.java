package iit.cs445.controllers.product.dvr;

import iit.cs445.models.products.HybridDVR;
import iit.cs445.models.products.StorageType;
import iit.cs445.models.users.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HybridDVRController {

    @RequestMapping(value = "/product/dvr/hybrid", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<HybridDVR> list = new HybridDVR().listAll();
        model.addAttribute("hybridsDVR", list);
        return "product";
    }

    @RequestMapping(value = "/product/dvr/hybrid/add", method = RequestMethod.GET)
    public String showAddHybridDVRForm(Model model) {
        HybridDVR hybridDVR = new HybridDVR();
        model.addAttribute("hybridDVRForm", hybridDVR);
        return "productForm";
    }

    @RequestMapping(value = "/hybridDVR/{id}/cart", method = RequestMethod.GET)
    public String addHybridDVRToCart(HttpServletRequest request, @PathVariable("id") Long id, Model model) {
        HybridDVR hybridDVR = new HybridDVR().findById(id);
        saveCart(request, hybridDVR);
        List<HybridDVR> list = new HybridDVR().listAll();
        model.addAttribute("hybridsDVR", list);
        return "product";
    }

    private boolean saveCart(HttpServletRequest request, HybridDVR hybridDVR) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        cart.add(hybridDVR);
        return true;
    }

    @RequestMapping(value = "/hybridDVR/{id}/update", method = RequestMethod.GET)
    public String showUpdateHybridDVRForm(@PathVariable("id") Long id, Model model) {
        HybridDVR hybridDVR = new HybridDVR().findById(id);
        model.addAttribute("hybridDVRFormUpdate", hybridDVR);
        return "productForm";
    }

    @RequestMapping(value = "/hybridDVR/{id}/delete", method = RequestMethod.GET)
    public String deleteHybridDVR(@PathVariable("id") Long id, Model model) {
        HybridDVR hybridDVR = new HybridDVR().findById(id);
        hybridDVR.setDeleted(true);
        hybridDVR.update();
        List<HybridDVR> list = new HybridDVR().listAll();
        model.addAttribute("hybridsDVR", list);
        return "product";
    }

    @RequestMapping(value = "/hybridDVR", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("storage_types") String storageTypes,
                               @RequestParam("price") String price,
                               Model model) {
        saveHybridDVR(description, storageTypes, price);
        List<HybridDVR> list = new HybridDVR().listAll();
        model.addAttribute("hybridsDVR", list);
        return "product";
    }

    @RequestMapping(value = "/hybridDVRUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                               @RequestParam("description") String description,
                               @RequestParam("storage_types") String storageTypes,
                               @RequestParam("price") String price,
                               Model model) {
        updateHybridDVR(id, description, storageTypes, price);
        List<HybridDVR> list = new HybridDVR().listAll();
        model.addAttribute("hybridsDVR", list);
        return "product";
    }

    private void saveHybridDVR(String description, String storage, String price) {
        HybridDVR hybridDVR = new HybridDVR();
        hybridDVR.setPrice(Float.parseFloat(price));
        List<StorageType> storageTypes = new ArrayList<>();
        if (storage.equals("DISK_DRIVE")) {
            storageTypes.add(StorageType.DISK_DRIVE);
        } else if (storage.equals("USB")) {
            storageTypes.add(StorageType.USB);
        } else if (storage.equals("SSD")) {
            storageTypes.add(StorageType.SSD);
        } else if (storage.equals("SD_MEMORY_CARD")) {
            storageTypes.add(StorageType.SD_MEMORY_CARD);
        } else {
            storageTypes.add(StorageType.OTHER);
        }
        hybridDVR.setStorageTypes(storageTypes);
        hybridDVR.setDescription(description);
        hybridDVR.setDeleted(false);
        hybridDVR.saveNew();
    }

    private void updateHybridDVR(String id, String description, String storage, String price) {
        HybridDVR hybridDVROld = new HybridDVR().findById(Long.parseLong(id));
        hybridDVROld.setDeleted(true);
        hybridDVROld.update();

        HybridDVR hybridDVR = new HybridDVR();
        hybridDVR.setPrice(Float.parseFloat(price));
        List<StorageType> storageTypes = new ArrayList<>();
        if (storage.equals("DISK_DRIVE")) {
            storageTypes.add(StorageType.DISK_DRIVE);
        } else if (storage.equals("USB")) {
            storageTypes.add(StorageType.USB);
        } else if (storage.equals("SSD")) {
            storageTypes.add(StorageType.SSD);
        } else if (storage.equals("SD_MEMORY_CARD")) {
            storageTypes.add(StorageType.SD_MEMORY_CARD);
        } else {
            storageTypes.add(StorageType.OTHER);
        }
        hybridDVR.setStorageTypes(storageTypes);
        hybridDVR.setDescription(description);
        hybridDVR.setDeleted(false);
        hybridDVR.saveNew();
    }

}
