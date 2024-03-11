package oopEstore;

import java.util.ArrayList;
import java.util.List;

public final class Customer extends User {
    private BillingInformation billingInformation;
    private ShoppingCart cart = new ShoppingCart();
    private final List<Order> orders = new ArrayList<>();

    public Customer(int id, String name, int age, String emailAddress, Address homeAddress, String password, String phone) {
        super(id, name, age, emailAddress, homeAddress, password, phone);
    }

    public List<Item> viewCart() {
        return cart.view();
    }

    public void addToCart(Product product, int quantity) {
        cart.add(product, quantity);
    }

    public void removeFromCart(int productId) {
        cart.remove(productId);
    }

    public void checkout() {
        Order newOrder = Checkout.placeOrder(cart, billingInformation);
        orders.add(newOrder);
    }

    public void setBillingInformation(BillingInformation billingInformation) {
        this.billingInformation = billingInformation;
    }

    public List<Order> viewOrders() {
        return orders;
    }

}
