package oopEstore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Products {
    private static final List<Product> products = new ArrayList<>();
    private static int numberOfProducts;

    public static void add(Product... product) {
        products.addAll(Arrays.asList(product));
    }

    public static List<Product> view() {
        return products;
    }

    public static int generateProductId() {
        return ++numberOfProducts;
    }

    public static Product findProductById(int productId) {
        for (Product product : products) if (product.getId() == productId) return product;

        throw new IllegalArgumentException("No such product exists with id " + productId);
    }
}
