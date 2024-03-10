package oopEstore;

public class Item {
    private Product product;
    private int quantityOfProduct;

    public Item(Product product, int quantityOfProduct) {
        this.product = product;
        this.quantityOfProduct = quantityOfProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void updateQuantity(int quantity) {
        this.quantityOfProduct += quantity;
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
}
