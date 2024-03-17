package oopEstore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Inventory {
    private final List<Product> products = new ArrayList<>();
    private int lastProductCreated;

    public void add(Product... product) {
        products.addAll(Arrays.asList(product));
    }

    public List<Product> view() {
        return products;
    }

    public int generateProductId() {
        return ++lastProductCreated;
    }

    public Product findProductById(int productId) {
        for (Product product : products) if (product.getId() == productId) return product;

        throw new IllegalArgumentException("No such product exists with id " + productId);
    }

    public int getQuantityOf(int productId) {
        Product foundProduct = findProductById(productId);

        return foundProduct.getQuantity();
    }

    public static void updateProductQuantity(ShoppingCart cart) {
        for (Item item : cart.view()) {
            Product product = item.getProduct();
            int newProductQuantity = product.getQuantity() - item.getQuantityOfProduct();
            product.updateQuantity(newProductQuantity);
        }

    }

    public static void validateQuantityOf(Product product, int quantity) {
        if (quantity > product.getQuantity())
            throw new IllegalArgumentException("Selected quantity: " + quantity + " exceeds available product quantity: " + product.getQuantity());
    }
}
