package iit.cs445.models.orders;

public interface OrderService {

    default Boolean createNewOrder(Order order) {
        return null;
    }

    default Boolean updateOrder(Order order) {
        return null;
    }

    default Boolean deleteOrder(Order order) {
        return null;
    }

}