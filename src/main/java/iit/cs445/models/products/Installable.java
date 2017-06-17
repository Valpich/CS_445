package iit.cs445.models.products;

import java.util.ArrayList;
import java.util.List;

public interface Installable {

    default Float installPrice() {
        return new Float(0);
    }

    default List<Equipment> installEquipments() {
        return new ArrayList<>();
    }
}
