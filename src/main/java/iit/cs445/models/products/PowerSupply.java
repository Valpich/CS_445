package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "power_supply")
public class PowerSupply extends Accessory<PowerSupply> implements Installable, Repairable {

    @Column(name = "description")
    private String description;

    @Column(name = "maximum_output")
    private String maximum_output;

    @Column(name = "voltage")
    private Float voltage;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PowerSupply{" +
                "description='" + description + '\'' +
                ", maximum_output='" + maximum_output + '\'' +
                ", voltage=" + voltage +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PowerSupply that = (PowerSupply) o;

        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (maximum_output != null ? !maximum_output.equals(that.maximum_output) : that.maximum_output != null)
            return false;
        return voltage != null ? voltage.equals(that.voltage) : that.voltage == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (maximum_output != null ? maximum_output.hashCode() : 0);
        result = 31 * result + (voltage != null ? voltage.hashCode() : 0);
        return result;
    }

}
