package oopEstore;

import java.util.List;

public class Customer extends User {
    private BillingInformation billingInformation;
    private ShoppingCart cart = new ShoppingCart();

    public Customer(String name, int age, String emailAddress, Address homeAddress, String password, String phone) {
        super(name, age, emailAddress, homeAddress, password, phone);
    }

    public List<Item> viewCart() {
        return cart.view();
    }

    public void addToCart(Product product, int quantity) {
        cart.add(product, 1);
    }

    public void removeFromCart(int productId) {
        cart.remove(productId);
    }
}
