package iit.cs445.models.orders;

public class OrderManager implements OrderService{

    @Override
    public Boolean createNewOrder(Order order) {
        order.saveNew();
        return true;
    }

    @Override
    public Boolean updateOrder(Order order) {
        order.update();
        return true;
    }

    @Override
    public Boolean deleteOrder(Order order) {
        order.delete();
        return true;
    }
}
