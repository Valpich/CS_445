package iit.cs445.model.products;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Accessory extends Product {

    @Override
    public String toString() {
        return "Accessory{} " + super.toString();
    }
}

