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
        System.out.println("Order cancled (OrderID: "+orderID+")");
    }
    @Override
    public Order findOrderByID(String orderID) {
        return orderMap.get(orderID);
        //return null;
    }
    /*@Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orderMap.values());
    }*/
    @Override
    public String getAllOrders() {
        if(!orderMap.isEmpty()) {
            for (Order order : orderMap.values()) {
                System.out.println("------------------------\nOrder ID: " + order.orderID());
                System.out.println("Produkte: ");
                for (Product product : order.products().showAllProducts()) {
                    System.out.println("- " + product.name() + " - " + product.price() + " € ");
                }
                System.out.println("------------------------\n"+order.priceSum());
            }
            return "------------------------";
        }else {
            return "No Orders placed";
        }
    }
}
