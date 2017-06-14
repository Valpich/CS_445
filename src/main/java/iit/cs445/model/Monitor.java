package iit.cs445.model;


import javax.persistence.*;

@Entity
@Table(name = "monitor")
public class Monitor extends Accessory<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "size")
    private Float size;

    @Column(name = "max_resolution")
    private String maxResolution;

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

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public String getMaxResolution() {
        return maxResolution;
    }

    public void setMaxResolution(String maxResolution) {
        this.maxResolution = maxResolution;
    }
}
