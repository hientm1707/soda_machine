package entities.product;

public class ProductFactory{
    public static Product createProduct(int option) {
        switch (option){
            case 1:
                return Product.COKE;
            case 2:
                return Product.PEPSI;
            case 3:
                return Product.SODA;
            default:
                return Product.UNKNOWN;
        }
    }
}
