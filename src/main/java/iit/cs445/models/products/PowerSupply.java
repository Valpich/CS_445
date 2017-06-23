package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "power_supply")
public class PowerSupply extends Accessory<PowerSupply> implements Installable, Repairable {

    @Column(name = "maximum_output")
    private String maximum_output;

    @Column(name = "voltage")
    private Float voltage;

    public String getMaximum_output() {
        return maximum_output;
    }

    public void setMaximum_output(String maximum_output) {
        this.maximum_output = maximum_output;
    }

    public Float getVoltage() {
        return voltage;
    }

    public void setVoltage(Float voltage) {
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "PowerSupply{" +
                "maximum_output='" + maximum_output + '\'' +
                ", voltage=" + voltage +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PowerSupply that = (PowerSupply) o;

        if (maximum_output != null ? !maximum_output.equals(that.maximum_output) : that.maximum_output != null)
            return false;
        return voltage != null ? voltage.equals(that.voltage) : that.voltage == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (maximum_output != null ? maximum_output.hashCode() : 0);
        result = 31 * result + (voltage != null ? voltage.hashCode() : 0);
        return result;
    }
}
