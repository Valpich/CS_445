package iit.cs445.models.services;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "surveillance_system_repair")
public class SurveillanceSystemRepair extends Service<SurveillanceSystemRepair> {
    @Override
    public String toString() {
        return "SurveillanceSystemRepair{} " + super.toString();
    }
}

