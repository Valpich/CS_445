package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "power_supply")
public class PowerSupply extends Accessory<PowerSupply> implements Installable, Repairable {

    @Column(name = "maximum_output")
    private String maximumOutput;

    @Column(name = "voltage")
    private Float voltage;

    public String getMaximumOutput() {
        return maximumOutput;
    }

    public void setMaximumOutput(String maximumOutput) {
        this.maximumOutput = maximumOutput;
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
                "maximum_output='" + maximumOutput + '\'' +
                ", voltage=" + voltage +
                "} " + super.toString();
    }

}
