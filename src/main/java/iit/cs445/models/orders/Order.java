package iit.cs445.models.orders;

import iit.cs445.models.BaseEntity;
import iit.cs445.models.products.OrderedProducts;
import iit.cs445.models.users.Address;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order")
public class Order extends BaseEntity<Long, Order> {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private OrderStatus status;

    @Column(name = "order_type")
    private OrderType orderType;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "orderId")
    @PrimaryKeyJoinColumn
    private List<OrderedProducts> orderedProducts;

    @OneToOne
    @JoinColumn(name = "id")
    private Address billingAddress;

    @OneToOne
    @JoinColumn(name = "id")
    private Address shippingAddress;

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

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public List<OrderedProducts> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderedProducts> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", orderType=" + orderType +
                ", orderedProducts=" + orderedProducts +
                ", billingAddress=" + billingAddress +
                ", shippingAddress=" + shippingAddress +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (status != order.status) return false;
        if (orderType != order.orderType) return false;
        if (orderedProducts != null ? !orderedProducts.equals(order.orderedProducts) : order.orderedProducts != null)
            return false;
        if (billingAddress != null ? !billingAddress.equals(order.billingAddress) : order.billingAddress != null)
            return false;
        return shippingAddress != null ? shippingAddress.equals(order.shippingAddress) : order.shippingAddress == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (orderType != null ? orderType.hashCode() : 0);
        result = 31 * result + (orderedProducts != null ? orderedProducts.hashCode() : 0);
        result = 31 * result + (billingAddress != null ? billingAddress.hashCode() : 0);
        result = 31 * result + (shippingAddress != null ? shippingAddress.hashCode() : 0);
        return result;
    }


}