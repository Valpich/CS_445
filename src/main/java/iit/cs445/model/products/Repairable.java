package iit.cs445.model.products;

import java.util.ArrayList;
import java.util.List;

public interface Repairable {

    default Float repairPrice() {
        return new Float(0);
    }

    default List<Equipment> repairEquipments() {
        return new ArrayList<>();
    }
}
