package iit.cs445.models.products;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public abstract class DVR extends Product {

    @Column(name = "storage_types")
    @Enumerated
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
}

