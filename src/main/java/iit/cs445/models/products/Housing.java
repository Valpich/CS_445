package iit.cs445.models.products;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "housing")
public class Housing extends Accessory<Housing> implements Installable, Repairable {

    @Override
    public String toString() {
        return "Housing{} " + super.toString();
    }
}
