package iit.cs445.models.products;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bracket")
public class Bracket extends Accessory<Bracket> implements Installable, Repairable {

    @Override
    public String toString() {
        return "Bracket{} " + super.toString();
    }
}
