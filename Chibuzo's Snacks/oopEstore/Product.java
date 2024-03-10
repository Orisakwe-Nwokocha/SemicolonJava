package oopEstore;

public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private ProductCategory category;

    public Product(int id, String name, double price, String description, ProductCategory category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("%n\tid => %d%n\t%s%n\t%s%n\t₦%,.2f", id, name, description, price);
    }


    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
