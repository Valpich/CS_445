package iit.cs445.models.products;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ip_surveillance_camera")
public class IPSurveillanceCamera extends SecurityCamera<IPSurveillanceCamera> implements Installable, Repairable {

    @Override
    public String toString() {
        return "IPSurveillanceCamera{} " + super.toString();
    }
}
