package org.example;

import java.util.List;

public interface OrderRepo {
    void addOrder(Order order);
    void cancelOrder(String orderID);
    Order findOrderByID(String orderID);
    List<Order> getAllOrders();
}
