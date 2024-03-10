package oopEstore;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order {
    private final int orderID;
    private final int numberOfItems;
    private final String items;
    private final double totalPrice;
    private final String orderDate;
    private static int count = 0;

    public Order(ShoppingCart cart, double totalPrice) {
        orderID = ++count;
        numberOfItems = cart.view().size();
        items = getItems(cart);
        this.totalPrice = totalPrice;
        orderDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MMM/yyyy"));
    }

    private static String getItems(ShoppingCart cart) {
        StringBuilder items = new StringBuilder();

        String asterisks = "*".repeat(17);

        items.append("\n").append(asterisks).append("\n");
        for (Item item : cart.view()) items.append(item).append("\n").append(asterisks).append("\n");

        return items.toString();
    }

    @Override
    public String toString() {
        return String.format("""
                Order Id: %d
                Number of items: %s
                Items: %sTotal Price: ₦%,.2f
                Order Date: %s
                """, orderID, numberOfItems, items, totalPrice, orderDate);
    }
}
