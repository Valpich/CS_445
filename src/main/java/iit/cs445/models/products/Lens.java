package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "lens")
public class Lens extends Accessory<Lens> implements Installable, Repairable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lens lens = (Lens) o;

        if (description != null ? !description.equals(lens.description) : lens.description != null) return false;
        if (focal != null ? !focal.equals(lens.focal) : lens.focal != null) return false;
        return magnification != null ? magnification.equals(lens.magnification) : lens.magnification == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (focal != null ? focal.hashCode() : 0);
        result = 31 * result + (magnification != null ? magnification.hashCode() : 0);
        return result;
    }

}
