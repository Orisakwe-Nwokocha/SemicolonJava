package oopEstore;

import oopEstore.exceptions.IncorrectPasswordException;
import java.util.ArrayList;
import java.util.List;

public final class Admin extends User {
    private List<Customer> customers = new ArrayList<>();
    private Inventory inventory = new Inventory();
    private int numberOfCustomers;

    public Admin() {}

    public Admin(int id, String name, int age, String emailAddress, Address homeAddress, String password, String phone) {
        super(id, name, age, emailAddress, homeAddress, password, phone);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer registerCustomer(String name, int age, String emailAddress, Address homeAddress, String password, String phone) {
        Customer newCustomer = new Customer(++numberOfCustomers, name, age, emailAddress, homeAddress, password, phone);
        customers.add(newCustomer);

        return newCustomer;
    }

    public void removeCustomerAccount(int customerId, String password) {
        Customer customer = findCustomer(customerId);
        validate(customer, password);

        customers.remove(customer);
    }

    private static void validate(Customer customer, String password) {
        if (!customer.isCorrect(password)) throw new IncorrectPasswordException("Password provided is not correct");
    }

    public Customer findCustomer(int customerId) {
        for (Customer customer : customers) if (customer.getId() == customerId) return customer;
        throw new IllegalArgumentException("Customer with id " + customerId + " not found");
    }

    public List<Product> getProducts() {
        return inventory.view();
    }

    public void addInitialInventory() {
        Product electronic = new Product(inventory.generateProductId(), "Pixel", 350_000.0, "Android smartphone",
                ProductCategory.ELECTRONICS, 10);
        Product grocery = new Product(inventory.generateProductId(), "Magic", 2_000.0, "Chocolate", ProductCategory.GROCERIES, 50);
        Product utensil = new Product(inventory.generateProductId(), "Plate", 1_000.0, "Earthenware", ProductCategory.UTENSILS, 25);
        Product clothing = new Product(inventory.generateProductId(), "Levis", 20_000.0, "Jeans", ProductCategory.CLOTHING, 30);

        inventory.add(electronic, grocery, utensil, clothing);
    }


    private record Create(Product electronic, Product grocery, Product utensil, Product clothing) {
    }

    public Product findProductById(int productId) {
        return inventory.findProductById(productId);
    }
}
