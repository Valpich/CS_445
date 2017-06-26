package iit.cs445.controllers.product.dvr;

import iit.cs445.models.products.DigitalDVR;
import iit.cs445.models.products.StorageType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DigitalDVRController {

    @RequestMapping(value = "/product/dvr/digital", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<DigitalDVR> list = new DigitalDVR().listAll();
        model.addAttribute("digitalsDVR", list);
        return "product";
    }

    @RequestMapping(value = "/product/dvr/digital/add", method = RequestMethod.GET)
    public String showAddDigitalDVRForm(Model model) {
        DigitalDVR digitalDVR = new DigitalDVR();
        model.addAttribute("digitalDVRForm", digitalDVR);
        return "productForm";
    }

    @RequestMapping(value = "/digitalDVR", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("storage_types") String storageTypes,
                               @RequestParam("price") String price) {
        saveDigitalDVR(description, storageTypes, price);
        return "index";
    }

    private void saveDigitalDVR(String description, String storage, String price) {
        DigitalDVR digitalDVR = new DigitalDVR();
        digitalDVR.setPrice(Float.parseFloat(price));
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
        digitalDVR.setStorageTypes(storageTypes);
        digitalDVR.setDescription(description);
        digitalDVR.saveNew();
    }

}
