package org.sibadi.product;

import org.sibadi.Manufacturer;

import java.math.BigDecimal;

public class Fruit extends Product {
    public Fruit(String name, String description, BigDecimal price, Manufacturer manufacturer) {
        super(name, description, price, manufacturer);
    }
}