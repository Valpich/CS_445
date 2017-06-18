package iit.cs445.controllers;

import iit.cs445.models.products.Bracket;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class BracketController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    LocalSessionFactoryBean localSessionFactoryBean;

    @RequestMapping(value = "/bracket/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("bracket/create");
        return modelAndView;
    }


    @RequestMapping(value = "/bracket/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam("description") String description, @RequestParam("price") Integer price) {
        ModelAndView modelAndView = new ModelAndView("index");
        Bracket bracket = new Bracket();
        bracket.setCreationTime(new Date());
        bracket.setModificationTime(bracket.getCreationTime());
        bracket.setDescription(description);
        bracket.setPrice(price);
        bracket.saveNew();
        return modelAndView;
    }

    @RequestMapping(value = "/bracket/remove/{id}", method = RequestMethod.GET)
    public ModelAndView remove(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("index");
        Session session = localSessionFactoryBean.getObject().openSession();
        String query = "select bracket from Bracket bracket";
        List results = session.createQuery(query).list();
        if(results != null){
            Bracket bracket = (Bracket) results.get(0);
            bracket.update();
        }
        return modelAndView;
    }

    @RequestMapping(value = "/bracket/modify", method = RequestMethod.GET)
    public ModelAndView modify() {
        ModelAndView modelAndView = new ModelAndView("index");
        Session session = localSessionFactoryBean.getObject().openSession();
        String query = "select bracket from Bracket bracket";
        List results = session.createQuery(query).list();
        if(results != null){
            Bracket bracket = (Bracket) results.get(0);
            bracket.delete();
        }
        return modelAndView;
    }
}
