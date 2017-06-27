package iit.cs445.controllers.product.accessory;

import iit.cs445.models.products.Connector;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ConnectorController {

    @RequestMapping(value = "/product/accessory/connector", method = RequestMethod.GET)
    public String listAll(Model model) {
        List<Connector> list = new Connector().listAll();
        model.addAttribute("conenctors", list);
        return "product";
    }

    @RequestMapping(value = "/product/accessory/connector/add", method = RequestMethod.GET)
    public String showConnectorForm(Model model) {
        Connector connector = new Connector();
        model.addAttribute("connectorForm", connector);
        return "productForm";
    }

    @RequestMapping(value = "/connector/{id}/update", method = RequestMethod.GET)
    public String showUpdateConnectorForm(@PathVariable("id") Long id, Model model) {
        Connector connector = new Connector().findById(id);
        model.addAttribute("connectorFormUpdate", connector);
        return "productForm";
    }

    @RequestMapping(value = "/connector/{id}/delete", method = RequestMethod.GET)
    public String deleteConnector(@PathVariable("id") Long id, Model model) {
        Connector connector = new Connector().findById(id);
        connector.setDeleted(true);
        connector.update();
        model.addAttribute("connectorForm", connector);
        return "index";
    }

    @RequestMapping(value = "/connector", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("description") String description,
                               @RequestParam("price") String price) {
        saveConnector(description, price);
        return "index";
    }

    @RequestMapping(value = "/connectorUpdate", method = RequestMethod.POST)
    public String checkoutPost(@RequestParam("id") String id,
                               @RequestParam("description") String description,
                               @RequestParam("price") String price) {
        updateConnector(id, description, price);
        return "index";
    }

    private void saveConnector(String description, String price) {
        Connector connector = new Connector();
        connector.setPrice(Float.parseFloat(price));
        connector.setDescription(description);
        connector.setDeleted(false);
        connector.saveNew();
    }

    private void updateConnector(String id, String description, String price) {
        Connector connectorOld = new Connector().findById(Long.parseLong(id));
        connectorOld.setDeleted(true);
        connectorOld.update();

        Connector connector = new Connector();
        connector.setPrice(Float.parseFloat(price));
        connector.setDescription(description);
        connector.setDeleted(false);
        connector.saveNew();
    }

}
