package iit.cs445.model.services;

import javax.persistence.*;

@Entity
@Table(name = "other_service")
public class CustomService extends Service<Long> {

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

    @Override
    public String toString() {
        return "CustomService{" +
                "id=" + id +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}
