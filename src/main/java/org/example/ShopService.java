package org.example;

import java.util.ArrayList;
import java.util.List;

// Schritt 1: Implementiere eine Methode, um eine neue Bestellung aufzugeben.
// Schritt 2: Überprüfe, ob die bestellten Produkte existieren. Wenn nicht gebe ein System.out.println aus.

public class ShopService {
    private static int countIDs = 0;
    private ProductRepo myCart;
    private OrderRepo myOrder;

    public ShopService(ProductRepo myCart, OrderRepo myOrder) {
        this.myCart = myCart;
        this.myOrder = myOrder;
    }

    public void placeOrder(ProductRepo products){
        Order order = new Order(generateOrderID(), products, getPriceSum(products.showAllProducts()));
        myOrder.addOrder(order);
        System.out.println("Order placed. Your Order ID: "+order.orderID());
    }
    private String generateOrderID(){
        //To-do get date
        return "23-09-04-"+(++countIDs);
    }
    private double getPriceSum(List<Product> items){
        double summe = 0;
        if(!items.isEmpty())
            for (Product order : items)
                summe += order.price();

        return summe;
    }
}
