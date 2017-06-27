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

    @Column(name = "deleted")
    private Boolean deleted = false;

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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Service{" +
                "price=" + price +
                ", description=" + description +
                ", deleted='" + deleted + '\'' +
                "} " + super.toString();
    }

}

