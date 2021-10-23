package interfaces;

import entities.product.Product;

public interface Releasable {
    void releaseProduct(Product product, int quantity);
}
