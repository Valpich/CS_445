package iit.cs445.controllers.product.dvr;

import iit.cs445.models.products.HybridDVR;
import iit.cs445.models.products.StorageType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/hybridDVR", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description ,
                               @RequestParam("storage_types") String storageTypes ,
                               @RequestParam("price") String price ) {
        saveHybridDVR(description, storageTypes, price);
        return "index";
    }

    private void saveHybridDVR(String description, String storage, String price) {
        HybridDVR hybridDVR = new HybridDVR();
        hybridDVR.setPrice(Float.parseFloat(price));
        List<StorageType> storageTypes = new ArrayList<>();
        if(storage.equals("DISK_DRIVE")) {
            storageTypes.add(StorageType.DISK_DRIVE);
        } else if(storage.equals("USB")) {
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
        hybridDVR.saveNew();
    }

}
