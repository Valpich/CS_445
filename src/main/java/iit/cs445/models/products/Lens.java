package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lens")
public class Lens extends Accessory<Lens> implements Installable, Repairable {

    @Column(name = "focal")
    private Float focal;

    @Column(name = "magnification")
    private Float magnification;

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
                "focal=" + focal +
                ", magnification=" + magnification +
                "} " + super.toString();
    }
}
