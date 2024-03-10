package oopEstore;

public class Checkout {
    public static Order placeOrder(ShoppingCart cart, BillingInformation billingInformation) {
        validate(billingInformation);
        double totalPrice = calculateTotalPrice(cart);

        return new Order(cart, totalPrice);
    }

    private static double calculateTotalPrice(ShoppingCart cart) {
        double totalPrice = 0.0;
        for (Item item : cart.view()) {
            Product product = item.getProduct();
            int quantity = item.getQuantityOfProduct();

            totalPrice += (product.getPrice() * quantity);
        }

        return totalPrice;
    }

    private static void validate(BillingInformation billingInformation) {
        if (billingInformation == null) throw new UnsuccessfulTransactionException("Cancelled - payment unsuccessful");
    }
}
