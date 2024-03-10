package oopEstore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Products {
    private static final List<Product> products = new ArrayList<>();
    private static int numberOfProducts;

    public static void add(Product... product) {
        products.addAll(Arrays.asList(product));
    }

    public static List<Product> view() {
        add();
        return products;
    }

    public static int generateProductId() {
        return ++numberOfProducts;
    }
}
