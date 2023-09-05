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
        Product stift = new Product("123","Bleistift 3er Set", 2.99,10);
        Product pinsel = new Product("124","Pinsel", 15.45,10);
        Product farben = new Product("125","Aquarellfarben", 102.99,10);
        Product papierW = new Product("126","Aquarellpapier 25 Blatt", 52.20, 10);
        Product papierN = new Product("127","Zeichenpapier", 32.46,10);

        ProductRepo wahrenKorb1 = new ProductRepo();
        OrderRepo bestellungen = new OrderMapRepo();
        ShopService sitzung1 = new ShopService(wahrenKorb1, bestellungen);

        ProductRepo wahrenKorb2 = new ProductRepo();
        ShopService sitzung2 = new ShopService(wahrenKorb2, bestellungen);

        //Produkte hinzufügen Sitzung1
        wahrenKorb1.addProduct(stift);
        wahrenKorb1.addProduct(papierN);
        wahrenKorb1.addProduct(papierW);
        System.out.println("Im Korb 1 "+wahrenKorb1.showAllProducts());
        wahrenKorb1.removeProduct("126");
        System.out.println("Produkt gelöscht "+wahrenKorb1.showAllProducts());

        //Produkte hinzufügen Sitzung 2
        wahrenKorb2.addProduct(pinsel);
        wahrenKorb2.addProduct(farben);
        wahrenKorb2.addProduct(papierW);
        System.out.println("Im Korb 2 "+wahrenKorb2.showAllProducts());

        //Bestellen
        sitzung1.placeOrder(wahrenKorb1);
        System.out.println(bestellungen.getAllOrders());

        sitzung2.placeOrder(wahrenKorb2);
        System.out.println(bestellungen.getAllOrders());

        //Cancel Bestellung 1
        bestellungen.cancelOrder("23-09-04-1");
        System.out.println(bestellungen.getAllOrders());
    }

    /*public static String orderOverview(List<Order> allOrders){
        if(!allOrders.isEmpty()) {
            for (Order order : allOrders) {
                double sumPrice = 0;
                System.out.println("------------------------\nOrder ID: " + order.orderID());
                System.out.println("Produkte: ");
                for (Product product : order.products().showAllProducts()) {
                    sumPrice += product.price();
                    System.out.println("- " + product.name() + " - " + product.price() + " € ");
                }
                System.out.println("------------------------\n Summe "+sumPrice);
            }
            return "------------------------";
        }else {
            return "No Orders placed";
        }
    }*/
}