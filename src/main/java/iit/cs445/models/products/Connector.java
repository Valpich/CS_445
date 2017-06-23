package iit.cs445.models.products;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "connector")
public class Connector extends Accessory<Connector> implements Installable, Repairable {

    @Override
    public String toString() {
        return "Connector{} " + super.toString();
    }
}
