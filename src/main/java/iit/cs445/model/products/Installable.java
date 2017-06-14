package iit.cs445.model.products;

import java.util.ArrayList;
import java.util.List;

public interface Installable {
    
    default public Float installPrice(){
        return new Float(0);
    }

    default public List<Equipment> equipments(){
        return new ArrayList<>();
    }
}
