package org.example;

import java.util.List;

public record Order(String orderID, ProductRepo products) {
}
