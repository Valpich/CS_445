package iit.cs445.model.products;

import javax.persistence.*;

@MappedSuperclass
public abstract class Accessory<ID> extends Product {

    public abstract ID getId();

}

