package org.sibadi.product;

import org.sibadi.Manufacturer;

import javax.print.attribute.standard.PDLOverrideSupported;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Product {

    private static final List<Product> products = new ArrayList<Product>();

    private final Manufacturer manufacturer;
    private final String description;
    private final String name;

    private BigDecimal price;

    public Product(String name, String description, BigDecimal price, Manufacturer manufacturer){
        this.manufacturer = manufacturer;
        this.description = description;
        this.price = price;
        this.name = name;

        products.add(this);
    }

    protected void finalize(){
        products.remove(this);
    }

    public static List<Product> getProducts(){
        return products;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public String getDescription(){
        return  description;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name + " " + description + " " + price + " " + manufacturer;
    }
}