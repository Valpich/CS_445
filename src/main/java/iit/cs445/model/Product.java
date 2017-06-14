package iit.cs445.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Product<ID> extends BaseEntity {

    private Integer price;

    public abstract ID getId();

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

