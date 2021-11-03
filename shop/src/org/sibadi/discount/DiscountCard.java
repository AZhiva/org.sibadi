package org.sibadi.discount;

import org.sibadi.Receipt;
import org.sibadi.product.Product;

import java.math.BigDecimal;
import java.util.*;

public class DiscountCard {

    private final static List<DiscountCard> discountCards = new ArrayList<DiscountCard>();

    private final String identification;
    private final Date birth;
    private final Date date;

    private String proprietor;
    private String phone;

    public DiscountCard(String phone, String proprietor, Date birth) {
        identification = UUID.randomUUID().toString();
        date = Calendar.getInstance().getTime();
        this.birth = birth;

        setProprietor(proprietor);
        setPhone(phone);

        discountCards.add(this);
    }

    protected void finalize() {
        discountCards.remove(this);
    }

    public static List<DiscountCard> getDiscountCards(){
        return discountCards;
    }

    public BigDecimal getDiscount(Receipt receipt) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Product product : receipt.getProductList()) {
            if (Discount.getDiscounts().containsKey(product.getClass()))
                totalPrice = totalPrice.add(product.getPrice().multiply(Discount.getDiscounts().get(product.getClass())));
            else totalPrice = totalPrice.add(product.getPrice());
        }
        return totalPrice;
    }

    public void setProprietor(String proprietor) {
        this.proprietor = proprietor;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentification() {
        return identification;
    }

    public String getProprietor() {
        return proprietor;
    }

    public String getPhone() {
        return phone;
    }

    public Date getBirth() {
        return birth;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString(){
        return proprietor + " " + birth + " " + phone + " " + date + " " + identification;
    }
}