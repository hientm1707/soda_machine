package interfaces.impl;

import entities.product.Product;
import interfaces.Releasable;

public class ProductReleaser implements Releasable {
    @Override
    public void releaseProduct(Product product, int quantity) {
        System.out.println("Releasing product: " + product.getName() + "...");
    }
}
