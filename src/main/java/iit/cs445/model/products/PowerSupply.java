package iit.cs445.model.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "power_supply")
public class PowerSupply extends Accessory implements Installable, Repairable {

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
}
