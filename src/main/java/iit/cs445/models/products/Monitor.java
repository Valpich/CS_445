package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "monitor")
public class Monitor extends Accessory<Monitor> implements Installable, Repairable {

    @Column(name = "size")
    private Float size;

    @Column(name = "max_resolution")
    private String maxResolution;

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public String getMaxResolution() {
        return maxResolution;
    }

    public void setMaxResolution(String maxResolution) {
        this.maxResolution = maxResolution;
    }

    @Override
    public String toString() {
        return "Monitor{" +
                "size=" + size +
                ", maxResolution='" + maxResolution + '\'' +
                "} " + super.toString();
    }

}
