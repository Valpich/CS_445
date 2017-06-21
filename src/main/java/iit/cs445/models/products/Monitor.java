package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "monitor")
public class Monitor extends Accessory<Monitor> implements Installable, Repairable {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Monitor monitor = (Monitor) o;

        if (description != null ? !description.equals(monitor.description) : monitor.description != null) return false;
        if (size != null ? !size.equals(monitor.size) : monitor.size != null) return false;
        return maxResolution != null ? maxResolution.equals(monitor.maxResolution) : monitor.maxResolution == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (maxResolution != null ? maxResolution.hashCode() : 0);
        return result;
    }

}
