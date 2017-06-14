package iit.cs445.model.orders;

import iit.cs445.model.BaseEntity;
import iit.cs445.model.products.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order")
public class Order extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private OrderStatus status;

    @Column(name = "products")
    @OneToMany
    @JoinColumn(name = "id")
    private List<Product> products;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", products=" + products +
                '}';
    }
}