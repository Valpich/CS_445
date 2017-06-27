package iit.cs445.controllers.product.dvr;

import iit.cs445.models.products.AnalogDVR;
import iit.cs445.models.products.AnalogRecordFormat;
import iit.cs445.models.products.StorageType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AnalogDVRController {

    @RequestMapping(value = "/product/dvr/analog", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<AnalogDVR> list = new AnalogDVR().listAll();
        model.addAttribute("analogsDVR", list);
        return "product";
    }

    @RequestMapping(value = "/product/dvr/analog/add", method = RequestMethod.GET)
    public String showAddAnalogDVRForm(Model model) {
        AnalogDVR analogDVR = new AnalogDVR();
        model.addAttribute("analogDVRForm", analogDVR);
        return "productForm";
    }

    @RequestMapping(value = "/analogDVR/{id}/update", method = RequestMethod.GET)
    public String showUpdateAnalogDVRForm(@PathVariable("id") Long id, Model model) {
        AnalogDVR analogDVR = new AnalogDVR().findById(id);
        model.addAttribute("analogDVRFormUpdate", analogDVR);
        return "productForm";
    }

    @RequestMapping(value = "/analogDVR/{id}/delete", method = RequestMethod.GET)
    public String deleteAnalogDVR(@PathVariable("id") Long id, Model model) {
        AnalogDVR analogDVR = new AnalogDVR().findById(id);
        analogDVR.setDeleted(true);
        analogDVR.update();
        model.addAttribute("analogDVRForm", analogDVR);
        return "index";
    }

    @RequestMapping(value = "/analogDVR", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("analog_record_formats") String analogRecord,
                               @RequestParam("storage_types") String storageTypes,
                               @RequestParam("price") String price) {
        saveAnalogDVR(description, analogRecord, storageTypes, price);
        return "index";
    }

    @RequestMapping(value = "/analogDVRUpdate", method = RequestMethod.POST)
    public String checkoutPostUpdate(@RequestParam("id") String id,
                                     @RequestParam("description") String description,
                                     @RequestParam("analog_record_formats") String analogRecord,
                                     @RequestParam("storage_types") String storageTypes,
                                     @RequestParam("price") String price) {
        updateAnalogDVR(id, description, analogRecord, storageTypes, price);
        return "index";
    }

    private void saveAnalogDVR(String description, String analogRecord, String storage, String price) {
        AnalogDVR analogDVR = new AnalogDVR();
        List<AnalogRecordFormat> analogRecordFormats = new ArrayList<>();
        if (analogRecord.equals("NTSC")) {
            analogRecordFormats.add(AnalogRecordFormat.NTSC);
        } else if (analogRecord.equals("PAL")) {
            analogRecordFormats.add(AnalogRecordFormat.PAL);
        } else {
            analogRecordFormats.add(AnalogRecordFormat.SECAM);
        }
        analogDVR.setAnalogRecordFormats(analogRecordFormats);
        analogDVR.setPrice(Float.parseFloat(price));
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
        analogDVR.setStorageTypes(storageTypes);
        analogDVR.setDescription(description);
        analogDVR.setDeleted(false);
        analogDVR.saveNew();
    }

    private void updateAnalogDVR(String id, String description, String analogRecord, String storage, String price) {
        AnalogDVR analogDVROld = new AnalogDVR().findById(Long.parseLong(id));
        analogDVROld.setDeleted(true);
        analogDVROld.update();

        AnalogDVR analogDVR = new AnalogDVR();
        List<AnalogRecordFormat> analogRecordFormats = new ArrayList<>();
        if (analogRecord.equals("NTSC")) {
            analogRecordFormats.add(AnalogRecordFormat.NTSC);
        } else if (analogRecord.equals("PAL")) {
            analogRecordFormats.add(AnalogRecordFormat.PAL);
        } else {
            analogRecordFormats.add(AnalogRecordFormat.SECAM);
        }
        analogDVR.setAnalogRecordFormats(analogRecordFormats);
        analogDVR.setPrice(Float.parseFloat(price));
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
        analogDVR.setStorageTypes(storageTypes);
        analogDVR.setDescription(description);
        analogDVR.setDeleted(false);
        analogDVR.saveNew();
    }

}
