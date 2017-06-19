package iit.cs445.models.services;

import iit.cs445.models.BaseEntity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Service<ID, Type> extends BaseEntity<ID, Type> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Service<?, ?> service = (Service<?, ?>) o;

        return price != null ? price.equals(service.price) : service.price == null;
    }

    @Override
    public int hashCode() {
        return price != null ? price.hashCode() : 0;
    }
}

