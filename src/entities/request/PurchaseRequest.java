package entities.request;

import entities.product.Product;

public class PurchaseRequest {
    private final Product product;
    private final int quantity;

    public PurchaseRequest(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
