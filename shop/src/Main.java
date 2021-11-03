import org.sibadi.Manufacturer;
import org.sibadi.Receipt;
import org.sibadi.discount.Discount;
import org.sibadi.discount.DiscountCard;
import org.sibadi.product.Fruit;
import org.sibadi.product.Meat;
import org.sibadi.product.Milk;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {

        Discount.add(Milk.class, new BigDecimal(0.5));
        Discount.add(Meat.class, new BigDecimal(0.5));
        Discount.add(Fruit.class, new BigDecimal(0.5));

        System.out.println(Discount.getInstance().toString());

        var meat = new Meat("Мясо", "Вкусное", new BigDecimal(1000), Manufacturer.Ru);
        var milk = new Milk("Молоко", "Вкусное", new BigDecimal(1000), Manufacturer.En);
        var fruit = new Fruit("Фрукт", "Вкусный", new BigDecimal(1000), Manufacturer.En);

        System.out.println(meat.toString());
        System.out.println(milk.toString());
        System.out.println(fruit.toString() + "\n");

        var discountCard = new DiscountCard("123", "Борис", new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2005"));

        System.out.println(discountCard.toString() + "\n");

        var receipt = new Receipt();
        receipt.add(fruit);
        receipt.add(meat);
        receipt.add(milk);

        System.out.println(receipt.toString());

        System.out.println(discountCard.getDiscount(receipt));
    }
}