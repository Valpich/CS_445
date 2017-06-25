package iit.cs445.models.orders;

import iit.cs445.models.BaseEntity;
import iit.cs445.models.products.Product;
import iit.cs445.models.services.Service;
import iit.cs445.models.users.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Entity
@Table(name = "order")
public class Order extends BaseEntity<Long, Order> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "status")
    private OrderStatus status;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ordered_products", joinColumns = {
            @JoinColumn(name = "order_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "product_id",
                    nullable = false, updatable = false) })
    private List<Product> orderedProducts;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ordered_services", joinColumns = {
            @JoinColumn(name = "order_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "service_id",
                    nullable = false, updatable = false) })
    private List<Service> orderedServices;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "billing_address", joinColumns = {
            @JoinColumn(name = "order_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "address_id",
                    nullable = false, updatable = false) })
    private Address billingAddress;

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

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public List<Service> getOrderedServices() {
        return orderedServices;
    }

    public void setOrderedServices(List<Service> orderedServices) {
        this.orderedServices = orderedServices;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", orderedProducts=" + orderedProducts +
                ", orderedServices=" + orderedServices +
                ", billingAddress=" + billingAddress +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (status != order.status) return false;
        if (orderedProducts != null ? !orderedProducts.equals(order.orderedProducts) : order.orderedProducts != null)
            return false;
        if (orderedServices != null ? !orderedServices.equals(order.orderedServices) : order.orderedServices != null)
            return false;
        return billingAddress != null ? billingAddress.equals(order.billingAddress) : order.billingAddress == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (orderedProducts != null ? orderedProducts.hashCode() : 0);
        result = 31 * result + (orderedServices != null ? orderedServices.hashCode() : 0);
        result = 31 * result + (billingAddress != null ? billingAddress.hashCode() : 0);
        return result;
    }
}