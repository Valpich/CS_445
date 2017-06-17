package iit.cs445.models.products;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "housing")
public class Housing extends Accessory implements Installable, Repairable {

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Housing{" +
                "description='" + description + '\'' +
                "} " + super.toString();
    }
}
