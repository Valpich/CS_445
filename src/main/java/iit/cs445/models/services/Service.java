package iit.cs445.models.services;

import iit.cs445.models.BaseEntity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Service<ID> extends BaseEntity<ID> {

    private Integer price;

    public abstract ID getId();

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "price=" + price +
                "} " + super.toString();
    }
}

