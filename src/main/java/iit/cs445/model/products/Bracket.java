package iit.cs445.model.products;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "bracket")
@Configurable
@Component
public class Bracket extends Accessory implements Installable, Repairable {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    @Transient
    LocalSessionFactoryBean localSessionFactoryBean;

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Bracket{" +
                "description='" + description + '\'' +
                "} " + super.toString();
    }

    public void persist(){
        Session session = localSessionFactoryBean.getObject().openSession();
        Transaction tx = session.beginTransaction();
        session.save(this);
        tx.commit();
    }
}
