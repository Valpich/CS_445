package iit.cs445.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DVR<ID> extends BaseEntity {

    public abstract ID getId();
}

