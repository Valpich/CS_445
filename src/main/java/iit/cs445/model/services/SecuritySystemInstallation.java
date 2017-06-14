package iit.cs445.model.services;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SecuritySystemInstallation<ID> extends Service {

    public abstract ID getId();

}

