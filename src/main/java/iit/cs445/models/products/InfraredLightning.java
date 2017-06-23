package iit.cs445.models.products;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "infrared_lightning")
public class InfraredLightning extends Accessory<InfraredLightning> implements Installable, Repairable {

    @Override
    public String toString() {
        return "InfraredLightning{} " + super.toString();
    }
}
