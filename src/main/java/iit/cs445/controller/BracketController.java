package iit.cs445.controller;

import iit.cs445.model.products.Bracket;
import iit.cs445.model.products.DigitalDVR;
import iit.cs445.model.products.StorageType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BracketController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    LocalSessionFactoryBean localSessionFactoryBean;

    @RequestMapping(value = "/bracket/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView modelAndView = new ModelAndView("index");
        Bracket bracket = new Bracket();
        bracket.setCreationTime(new Date());
        bracket.setModificationTime(bracket.getCreationTime());
        bracket.saveNew();
        return modelAndView;
    }

    @RequestMapping(value = "/bracket/remove", method = RequestMethod.GET)
    public ModelAndView remove() {
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
