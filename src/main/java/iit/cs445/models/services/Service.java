package iit.cs445.models.services;

import iit.cs445.models.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Service<ID, Type> extends BaseEntity<ID, Type> {

    @Column(name = "price")
    private Float price;
    @Column(name = "description")
    private String description;

    public abstract ID getId();

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Service{" +
                "price=" + price +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Service<?, ?> service = (Service<?, ?>) o;

        if (price != null ? !price.equals(service.price) : service.price != null) return false;
        return description != null ? description.equals(service.description) : service.description == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}

