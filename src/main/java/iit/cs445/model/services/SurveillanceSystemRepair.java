package iit.cs445.model.services;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class SurveillanceSystemRepair<ID> extends Service {

    public abstract ID getId();

}

