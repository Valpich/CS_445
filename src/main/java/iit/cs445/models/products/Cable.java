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

}
