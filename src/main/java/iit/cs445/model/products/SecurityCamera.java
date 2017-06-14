package iit.cs445.model.products;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SecurityCamera<ID> extends Product {

    @Column(name = "resolution")
    private String resolution;

    public abstract ID getId();

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}

