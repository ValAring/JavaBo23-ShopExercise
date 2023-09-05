package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private List<Product> shoppingCart = new ArrayList<>();

    // Implementiere Methoden zum Hinzufügen, Entfernen und Abfragen von Produkten.
    public void addProduct(Product product){
        shoppingCart.add(product);
    }
    public String removeProduct(String iD){
        for(Product product : shoppingCart) {
            if (product.productID().equals(iD)) {
                shoppingCart.remove(product);
                return "Product removed";
            }
        }
        return "Product not found";
    }
    public Product findProductByID(String iD){
        for(Product product : shoppingCart) {
            if (product.productID().equals(iD)) {
                return product;
            }
        }
        return null;
    }
    public List<Product> showAllProducts(){
        return new ArrayList<>(shoppingCart);
    }
}
