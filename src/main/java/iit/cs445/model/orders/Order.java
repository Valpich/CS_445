package iit.cs445.model.orders;

import iit.cs445.model.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}