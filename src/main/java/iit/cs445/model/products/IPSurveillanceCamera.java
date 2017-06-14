package iit.cs445.model.products;


import javax.persistence.*;

@Entity
@Table(name = "ip_surveillance_camera")
public class IPSurveillanceCamera extends SecurityCamera<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
