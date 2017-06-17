package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lens")
public class Lens extends Accessory implements Installable, Repairable {

    @Column(name = "description")
    private String description;

    @Column(name = "focal")
    private Float focal;

    @Column(name = "magnification")
    private Float magnification;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getFocal() {
        return focal;
    }

    public void setFocal(Float focal) {
        this.focal = focal;
    }

    public Float getMagnification() {
        return magnification;
    }

    public void setMagnification(Float magnification) {
        this.magnification = magnification;
    }

    @Override
    public String toString() {
        return "Lens{" +
                "description='" + description + '\'' +
                ", focal=" + focal +
                ", magnification=" + magnification +
                "} " + super.toString();
    }
}
