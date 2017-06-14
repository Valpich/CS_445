package iit.cs445.model.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "monitor")
public class Monitor extends Accessory implements Installable, Repairable {

    @Column(name = "description")
    private String description;

    @Column(name = "size")
    private Float size;

    @Column(name = "max_resolution")
    private String maxResolution;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
                "description='" + description + '\'' +
                ", size=" + size +
                ", maxResolution='" + maxResolution + '\'' +
                "} " + super.toString();
    }
}
