package org.example;

import java.util.List;

/*
* Erstelle eine Klasse ProductRepo, die eine Liste von Product-Objekten enthält.
Schritt 1: Erstelle einen Record Product mit den benötigten Attributen.
Schritt 2: Implementiere die ProductRepo-Klasse mit einer Liste zur Speicherung von Produkten.
Schritt 3: Implementiere Methoden zum Hinzufügen, Entfernen und Abfragen von Produkten.

* Erstelle eine Klasse OrderListRepo, die eine Liste von Order-Objekten enthält.
Schritt 1: Erstelle einen Record Order mit den benötigten Attributen.
Schritt 2: Implementiere die OrderListRepo-Klasse mit einer Liste zur Speicherung von Bestellungen.
Schritt 3: Implementiere Methoden zum Hinzufügen, Entfernen und Abfragen von Bestellungen.

* Erstelle eine Klasse ShopService, über die wir neue Bestellungen aufgeben können.
Schritt 1: Implementiere eine Methode, um eine neue Bestellung aufzugeben.
Schritt 2: Überprüfe, ob die bestellten Produkte existieren. Wenn nicht gebe ein System.out.println aus.

* Order RepoInterface
Schritt 1: Erstelle ein OrderRepo-Interface mit den Methoden aus dem OrderListRepo
(Hinzufügen, Entfernen und Abfragen von Bestellungen)

* Order Map Repo
Erstelle eine Klasse OrderMapRepo, über die wir neue Bestellungen aufgeben können.
Diese Klasse soll auch das OrderRepo-Interface implementieren.
* Erstelle in der main-Methode entweder das OrderMapRepo oder das OrderListRepo und gib es dem Konstruktor von ShopService
(in einen Konstruktor-Parameter, der das Interface nutzt) mit.

* Bonus Aufgaben
* Preis und Anzahl
Für diejenigen mit Vorwissen oder zusätzlichem Interesse an Herausforderungen.
Füge ein Preis zum Produkt und einen Gesamtpreis für eine Bestellung hinzu.
Erlaube es dem Nutzer, die Anzahl der Produkte in einer Bestellung anzugeben und zu ändern.

* Tests
Schreibe sinnvolle Tests für die Klassen ProductRepo, OrderListRepo und ShopService.
Nutze assertj matchers in deinen Tests.

* Kommandozeilen-Interface
Nutze einen Scanner um von System.in zu lesen. Baue eine interaktive Produktverwaltung mit allen Extras.

* Kommandozeilen-Farbe
Gestalte die Kommandozeilenausgabe farbig mit sinnvollen, hilfreichen Farben und Formen.

* EAN Datenbank
Suche im Internet eine EAN-Datenbank als CSV (oder lass eine von ChatGPT generieren). Nutze diese CSV-Datei als Input

* BestandsInfo
Speichert pro Produkt, wie viele davon noch auf Lager sind. Wenn ein Produkt bestellt wird, wird der Bestand verringert.
Wenn ein Produkt nicht mehr auf Lager ist, kann es nicht mehr bestellt werden.

* Warenein- und ausgänge
Ermöglicht zusätzliche Workflows für Warenein- und ausgänge. Wenn Ware eingelagert wird, wird der Bestand erhöht.
Wenn Ware ausgelagert wird (z.B. nach einem Wasserschaden oder Diebstahl), wird der Bestand verringert.

* Bestandsprotokoll
Notiere für den Warenbestand ein Protokoll aller Warenbestandsänderungen mit Verknüpfungen zu den Bestellungen
(oder Warenein- oder ausgängen), die diese Änderungen verursacht haben.

* */
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Shop!");
        Product stift = new Product("123","Bleistift 3er Set", 2.99,73);
        Product pinsel = new Product("124","Pinsel", 15.45,22);
        Product farben = new Product("125","Aquarellfarben", 102.99,5);
        Product papierW = new Product("126","Aquarellpapier 25 Blatt", 52.20, 45);
        Product papierN = new Product("127","Zeichenpapier", 32.46,68);

        ProductRepo productRepo = new ProductRepo();
        OrderRepo orderRepo = new OrderMapRepo();
        ShopService shopService = new ShopService(productRepo, orderRepo);

        //Produkte hinzufügen
        productRepo.addProduct(stift);
        productRepo.addProduct(papierN);
        productRepo.addProduct(papierW);
        System.out.println("Im Korb "+productRepo.showAllProducts());
        productRepo.removeProduct("126");
        System.out.println("Produkt gelöscht "+productRepo.showAllProducts());

        //Bestellen
        shopService.placeOrder(productRepo);

        System.out.println(orderOverview(orderRepo.getAllOrders()));
    }

    public static String orderOverview(List<Order> allOrders){
        double sumPrice = 0;
        if(!allOrders.isEmpty()) {
            for (Order order : allOrders) {
                System.out.println("Order ID: " + order.orderID());
                System.out.println("Produkte: ");
                for (Product product : order.products().showAllProducts()) {
                    sumPrice += product.price();
                    System.out.println("- " + product.name() + " - " + product.price() + " € ");
                }
            }
            return "------------------------\n Summe "+sumPrice;
        }else {
            return "No Orders placed";
        }
    }
}