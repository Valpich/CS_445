package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.PowerSupply;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PowerSupplyController {

    @RequestMapping(value = "/product/accessory/power-supply", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<PowerSupply> list = new PowerSupply().listAll();
        model.addAttribute("powerSupplies", list);
        return "product";
    }

    @RequestMapping(value = "/product/accessory/powerSupply/add", method = RequestMethod.GET)
    public String showPowerSupplyForm(Model model) {
        PowerSupply powerSupply = new PowerSupply();
        model.addAttribute("powerSupplyForm", powerSupply);
        return "productForm";
    }

    @RequestMapping(value = "/powerSupply/{id}/update", method = RequestMethod.GET)
    public String showUpdatePowerSupplyForm(@PathVariable("id") Long id, Model model) {
        PowerSupply powerSupply = new PowerSupply().findById(id);
        model.addAttribute("powerSupplyFormUpdate", powerSupply);
        return "productForm";
    }

    @RequestMapping(value = "/powerSupply/{id}/delete", method = RequestMethod.GET)
    public String deletePowerSupply(@PathVariable("id") Long id, Model model) {
        PowerSupply powerSupply = new PowerSupply().findById(id);
        powerSupply.setDeleted(true);
        powerSupply.update();
        model.addAttribute("powerSupplyForm", powerSupply);
        return "index";
    }

    @RequestMapping(value = "/powerSupply", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description ,
                               @RequestParam("maximum_output") String maximumOutput ,
                               @RequestParam("voltage") String voltage ,
                               @RequestParam("price") String price ) {
        savePowerSupply(description, maximumOutput, voltage, price);
        return "index";
    }

    @RequestMapping(value = "/powerSupplyUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                                @RequestParam("description") String description ,
                                @RequestParam("maximum_output") String maximumOutput ,
                                @RequestParam("voltage") String voltage ,
                                @RequestParam("price") String price ) {
        updatePowerSupply(id, description, maximumOutput, voltage, price);
        return "index";
    }

    private void savePowerSupply(String description, String maximumOutput, String voltage, String price) {
        PowerSupply powerSupply = new PowerSupply();
        powerSupply.setPrice(Float.parseFloat(price));
        powerSupply.setMaximumOutput(maximumOutput);
        powerSupply.setVoltage(Float.parseFloat(voltage));
        powerSupply.setDescription(description);
        powerSupply.setDeleted(false);
        powerSupply.saveNew();
    }

    private void updatePowerSupply(String id, String description, String maximumOutput, String voltage, String price) {
        PowerSupply powerSupplyOld = new PowerSupply().findById(Long.parseLong(id));
        powerSupplyOld.setDeleted(true);
        powerSupplyOld.update();

        PowerSupply powerSupply = new PowerSupply();
        powerSupply.setPrice(Float.parseFloat(price));
        powerSupply.setMaximum_output(maximumOutput);
        powerSupply.setVoltage(Float.parseFloat(voltage));
        powerSupply.setDescription(description);
        powerSupply.setDeleted(false);
        powerSupply.saveNew();
    }

}
