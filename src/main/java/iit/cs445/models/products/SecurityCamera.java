package iit.cs445.models.products;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SecurityCamera<Type> extends Product<Type> {

    @Column(name = "resolution")
    private String resolution;

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "SecurityCamera{" +
                "resolution='" + resolution + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SecurityCamera that = (SecurityCamera) o;

        return resolution != null ? resolution.equals(that.resolution) : that.resolution == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (resolution != null ? resolution.hashCode() : 0);
        return result;
    }
}

