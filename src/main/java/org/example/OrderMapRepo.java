package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepo {
    private Map<String, Order> orderMap = new HashMap<>();
    @Override
    public void addOrder(Order order) {
        orderMap.put(order.orderID(), order);
    }
    @Override
    public void cancelOrder(String orderID) {
        orderMap.remove(orderID);
    }
    @Override
    public Order findOrderByID(String orderID) {
        return orderMap.get(orderID);
        //return null;
    }
    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderMap.values());
    }
}
