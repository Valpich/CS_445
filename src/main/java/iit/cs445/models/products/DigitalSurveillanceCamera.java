package iit.cs445.models.products;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "digital_surveillance_camera")
public class DigitalSurveillanceCamera extends SecurityCamera<DigitalSurveillanceCamera> implements Installable, Repairable {
    @Override
    public String toString() {
        return "DigitalSurveillanceCamera{} " + super.toString();
    }
}
