package iit.cs445.models.services;

import iit.cs445.models.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "service")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Service<Type> extends BaseEntity<Long, Type> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "price")
    private Float price;

    @Column(name = "description")
    private String description;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

        Service<?> service = (Service<?>) o;

        if (id != null ? !id.equals(service.id) : service.id != null) return false;
        if (price != null ? !price.equals(service.price) : service.price != null) return false;
        return description != null ? description.equals(service.description) : service.description == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}

