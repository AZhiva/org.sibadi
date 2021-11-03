package org.sibadi;

import org.sibadi.product.Product;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Receipt {
    private List<Product> productList;
    private Date date;

    public Receipt() {
        productList = new ArrayList<Product>();
        date = Calendar.getInstance().getTime();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Date getDate() {
        return date;
    }

    public void remove(Product product) {
        productList.remove(product);
    }

    public void add(Product product) {
        productList.add(product);
    }

    public void clear() {
        productList.clear();
    }

    @Override
    public String toString(){
        String outSting = new String();
        for (Product product : productList) {
            outSting += product.toString() + "\n";
        }
        outSting += date + "\n";
        return  outSting;
    }
}