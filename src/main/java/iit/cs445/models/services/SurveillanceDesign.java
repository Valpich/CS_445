package iit.cs445.models.services;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "surveillance_design")
public class SurveillanceDesign extends Service<SurveillanceDesign> {

    @Override
    public String toString() {
        return "SurveillanceDesign{} " + super.toString();
    }
}
