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
        Session session = localSessionFactoryBean.getObject().openSession();
        Transaction tx = session.beginTransaction();
        session.save(bracket);
        tx.commit();
        bracket.saveNew();
        bracket.update();
        bracket.delete();
        DigitalDVR dvr = new DigitalDVR();
        ArrayList<StorageType> types = new ArrayList();
        types.add(StorageType.DISK_DRIVE);
        types.add(StorageType.SSD);
        dvr.setStorageTypes(types);
        dvr.setCreationTime(new Date());
        dvr.setModificationTime(dvr.getCreationTime());
        session = localSessionFactoryBean.getObject().openSession();
        tx = session.beginTransaction();
        session.save(dvr);
        tx.commit();
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
            Transaction tx = session.beginTransaction();
            session.delete(bracket);
            tx.commit();
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
            Transaction tx = session.beginTransaction();
            session.update(bracket);
            tx.commit();
        }
        return modelAndView;
    }
}
