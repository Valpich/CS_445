package iit.cs445.model;


import javax.persistence.*;

@Entity
@Table(name = "lens")
public class Lens extends Accessory<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "focal")
    private Float focal;

    @Column(name = "magnification")
    private Float magnification;


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

    public Float getFocal() {
        return focal;
    }

    public void setFocal(Float focal) {
        this.focal = focal;
    }

    public Float getMagnification() {
        return magnification;
    }

    public void setMagnification(Float magnification) {
        this.magnification = magnification;
    }
}
