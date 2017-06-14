package iit.cs445.model.orders;

public interface OrderService {

    Boolean createNewOrder(Order order);

    Boolean updateOrder(Order order);

    Boolean deleteOrder(Order order);

}