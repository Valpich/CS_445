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

}
