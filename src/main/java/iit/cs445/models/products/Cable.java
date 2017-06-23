package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cable")
public class Cable extends Accessory<Cable> implements Installable, Repairable {

    @Column(name = "length")
    private Float length;

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Cable{" +
                "length=" + length +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cable cable = (Cable) o;

        return length != null ? length.equals(cable.length) : cable.length == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (length != null ? length.hashCode() : 0);
        return result;
    }
}
