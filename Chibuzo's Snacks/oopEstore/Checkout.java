package oopEstore;

import oopEstore.exceptions.UnsuccessfulTransactionException;

public class Checkout {
    public static Order placeOrder(ShoppingCart cart, BillingInformation billingInformation) {
        validate(cart, billingInformation);
        double totalPrice = calculateTotalPrice(cart);

        return new Order(cart, totalPrice);
    }

    public static double calculateTotalPrice(ShoppingCart cart) {
        double totalPrice = 0.0;
        for (Item item : cart.view()) {
            Product product = item.getProduct();
            int quantity = item.getQuantityOfProduct();

            totalPrice += (product.getPrice() * quantity);
        }

        return totalPrice;
    }

    private static void validate(ShoppingCart cart, BillingInformation billingInformation) {
        if (cart.view().isEmpty()) throw new IllegalStateException("Shopping cart is empty");

        CardType cardType = billingInformation.creditCardInfo().cardType();
        if (cardType == null) throw new UnsuccessfulTransactionException("Invalid card - payment unsuccessful");
    }
}
