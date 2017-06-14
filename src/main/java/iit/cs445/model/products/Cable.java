package iit.cs445.model.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cable")
public class Cable extends Accessory implements Installable, Repairable {

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
}
