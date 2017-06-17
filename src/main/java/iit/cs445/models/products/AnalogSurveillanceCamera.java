package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "analog_surveillance_camera")
public class AnalogSurveillanceCamera extends SecurityCamera implements Repairable, Installable {

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
        return "AnalogSurveillanceCamera{" +
                "description='" + description + '\'' +
                "} " + super.toString();
    }
}
