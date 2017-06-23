package iit.cs445.models.products;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "analog_surveillance_camera")
public class AnalogSurveillanceCamera extends SecurityCamera<AnalogSurveillanceCamera> implements Repairable, Installable {

    @Override
    public String toString() {
        return "AnalogSurveillanceCamera{} " + super.toString();
    }

}
