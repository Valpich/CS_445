package iit.cs445.model.products;

import java.util.ArrayList;
import java.util.List;

public interface Repairable {

    default public Float repairPrice(){
        return new Float(0);
    }

    default public List<Equipment> equipments(){
        return new ArrayList<>();
    }
}
