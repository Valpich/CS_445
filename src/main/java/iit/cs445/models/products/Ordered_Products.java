package iit.cs445.models.products;

import iit.cs445.models.orders.Order;

import javax.persistence.*;

@Entity
@Table(name = "ordered_products")
public class Ordered_Products {


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "ordered_products_id")
    private Long id;

    @Column(insertable = false, updatable = false)
    private Long orderId;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name="orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
