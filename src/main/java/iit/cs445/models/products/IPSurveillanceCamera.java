package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ip_surveillance_camera")
public class IPSurveillanceCamera extends SecurityCamera implements Installable, Repairable {

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
        return "IPSurveillanceCamera{" +
                "description='" + description + '\'' +
                "} " + super.toString();
    }
}
