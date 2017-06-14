package iit.cs445.model.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "digital_surveillance_camera")
public class DigitalSurveillanceCamera extends SecurityCamera implements Installable, Repairable {

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
        return "DigitalSurveillanceCamera{" +
                "description='" + description + '\'' +
                "} " + super.toString();
    }
}
