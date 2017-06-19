package iit.cs445.models.products;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Accessory<Type> extends Product<Type> {

    @Override
    public String toString() {
        return "Accessory{} " + super.toString();
    }


}

