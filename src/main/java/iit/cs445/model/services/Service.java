package iit.cs445.model.services;

import iit.cs445.model.BaseEntity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Service<ID> extends BaseEntity {

    private Integer price;

    public abstract ID getId();

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

