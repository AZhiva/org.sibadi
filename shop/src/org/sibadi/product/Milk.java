package org.sibadi.product;

import org.sibadi.Manufacturer;

import java.math.BigDecimal;

public class Milk extends Product {
    public Milk(String name, String description, BigDecimal price, Manufacturer manufacturer) {
        super(name, description, price, manufacturer);
    }
}