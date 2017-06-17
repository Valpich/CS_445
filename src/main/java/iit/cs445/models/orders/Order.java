package iit.cs445.models.orders;

import iit.cs445.models.BaseEntity;
import iit.cs445.models.products.Product;
import iit.cs445.models.users.Address;

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

    @Column(name = "order_type")
    private OrderType orderType;

    @Column(name = "products")
    @OneToMany
    @JoinColumn(name = "id")
    private List<Product> products;

    @Column(name = "billing_address")
    private Address billingAddress;


    @Column(name = "shipping_address")
    private Address shippingAddress;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}