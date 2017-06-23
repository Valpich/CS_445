package iit.cs445.models.products;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hybrid_dvr")
public class HybridDVR extends DVR<HybridDVR> implements Installable, Repairable {
    @Override
    public String toString() {
        return "HybridDVR{} " + super.toString();
    }
}
