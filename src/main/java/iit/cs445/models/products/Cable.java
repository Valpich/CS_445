package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "cable")
public class Cable extends Accessory<Cable> implements Installable, Repairable {

    @Column(name = "description")
    private String description;

    @Column(name = "length")
    private Float length;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Cable{" +
                "description='" + description + '\'' +
                ", length=" + length +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cable cable = (Cable) o;

        if (description != null ? !description.equals(cable.description) : cable.description != null) return false;
        return length != null ? length.equals(cable.length) : cable.length == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (length != null ? length.hashCode() : 0);
        return result;
    }

}
