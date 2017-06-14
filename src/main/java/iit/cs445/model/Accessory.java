package iit.cs445.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class Accessory<ID> extends BaseEntity {

    public abstract ID getId();
}

