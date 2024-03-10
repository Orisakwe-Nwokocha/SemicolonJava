package oopEstore;

public class Item {
    private Product product;
    private int quantityOfProduct;

    public Item(Product product, int quantityOfProduct) {
        validate(quantityOfProduct);

        this.product = product;
        this.quantityOfProduct = quantityOfProduct;
    }

    private static void validate(int quantityOfProduct) {
        if (quantityOfProduct <= 0) throw new IllegalArgumentException("Quantity of product must be greater than zero");
    }

    public Product getProduct() {
        return product;
    }

    public void updateQuantityOfProduct(int quantityOfProduct) {
        validate(quantityOfProduct);
        this.quantityOfProduct = quantityOfProduct;
    }

    @Override
    public String toString() {
        return String.format("Product: %s%nQuantity: %d", product, quantityOfProduct);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        return (obj instanceof Item item)
                && (this.product.equals(item.product)
                && this.quantityOfProduct == item.quantityOfProduct);
    }

    public int getQuantityOfProduct() {
        return quantityOfProduct;
    }
}
