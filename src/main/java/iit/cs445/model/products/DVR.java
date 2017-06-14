package iit.cs445.model.products;

import javax.persistence.*;
import java.util.List;

@MappedSuperclass
public abstract class DVR<ID> extends Product {

    @Column(name = "storage_types")
    @Enumerated
    @ElementCollection(targetClass = StorageType.class)
    private List<StorageType> storageTypes;

    public abstract ID getId();

    public List<StorageType> getStorageTypes() {
        return storageTypes;
    }

    public void setStorageTypes(List<StorageType> storageTypes) {
        this.storageTypes = storageTypes;
    }
}

