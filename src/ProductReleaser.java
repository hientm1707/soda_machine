import product.Product;

public class ProductReleaser implements Releasable {
    @Override
    public void releaseProduct(Product product, int quantity) {
        System.out.println("Releasing product: " + product.getName());
    }
}
