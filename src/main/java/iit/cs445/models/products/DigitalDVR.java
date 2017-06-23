package iit.cs445.models.products;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "digital_dvr")
public class DigitalDVR extends DVR<DigitalDVR> implements Installable, Repairable {

    @Override
    public String toString() {
        return "DigitalDVR{} " + super.toString();
    }
}
