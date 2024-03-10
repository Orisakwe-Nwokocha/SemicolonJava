package oopEstore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Customer extends User {
    private BillingInformation billingInformation;
    private final ShoppingCart cart = new ShoppingCart();
    private final List<Order> orders = new ArrayList<>();

    public Customer(String name, int age, String emailAddress, Address homeAddress, String password, String phone) {
        super(name, age, emailAddress, homeAddress, password, phone);
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
        setBillingInformation(billingInformation);

        Order order = Checkout.placeOrder(cart, billingInformation);
        orders.add(order);
    }

    public void setBillingInformation(BillingInformation billingInformation) {
        this.billingInformation = billingInformation;
    }

    public List<Order> viewOrders() {
        return orders;
    }
}
