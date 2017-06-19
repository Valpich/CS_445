package iit.cs445.models.products;

import org.hibernate.annotations.Cascade;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public abstract class DVR<Type> extends Product<Type> {

    @Column(name = "storage_types")
    @Enumerated
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @ElementCollection(targetClass = StorageType.class)
    private List<StorageType> storageTypes;

    public List<StorageType> getStorageTypes() {
        return storageTypes;
    }

    public void setStorageTypes(List<StorageType> storageTypes) {
        this.storageTypes = storageTypes;
    }

    @Override
    public String toString() {
        return "DVR{" +
                "storageTypes=" + storageTypes +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DVR dvr = (DVR) o;

        return storageTypes != null ? storageTypes.equals(dvr.storageTypes) : dvr.storageTypes == null;
    }

    @Override
    public int hashCode() {
        return storageTypes != null ? storageTypes.hashCode() : 0;
    }
}

