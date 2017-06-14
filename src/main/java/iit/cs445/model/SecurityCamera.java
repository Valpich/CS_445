package iit.cs445.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SecurityCamera<ID> extends BaseEntity {

    public abstract ID getId();
}

