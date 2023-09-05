package org.example;

import java.util.ArrayList;
import java.util.List;

/*
Schritt 1: Erstelle einen Record Order mit den benötigten Attributen.
Schritt 2: Implementiere die OrderListRepo-Klasse mit einer Liste zur Speicherung von Bestellungen.
Schritt 3: Implementiere Methoden zum Hinzufügen, Entfernen und Abfragen von Bestellungen.*/
public class OrderListRepo {
    private static List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){
        orders.add(order);
    }
    public String cancelOrder(String iD){
        for(Order order : orders){
            if(order.orderID().equals(iD)){
                orders.remove(order);
                return "Bestellung storniert";
            }
        }
        return "Bestellung nicht gefunden.";
    }
    public Order findOrderByID(String iD){
        for(Order order : orders){
            if(order.orderID().equals(iD)){
                return order;
            }
        }
        return null;
    }
    public List<Order> getAllOrders(){
        return new ArrayList<>(orders);
    }
}
