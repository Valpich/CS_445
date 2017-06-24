package iit.cs445.controllers;

import iit.cs445.models.products.Cable;
import iit.cs445.models.services.CustomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DebugController {

    @RequestMapping(value = "/populate/database", method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        Cable cable = new Cable();
        cable.setId(new Long(2));
        cable.setPrice(new Float(44.2));
        cable.setLength(new Float(24.3));
        cable.setDescription("Cable test");
        CustomService customService = new CustomService();
        customService.setId(new Long(3));
        customService.setPrice(new Float(32.2));
        customService.setDescription("Service test");
        return "redirect:/";
    }

}
