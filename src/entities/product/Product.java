package entities.product;

public enum Product {

    COKE(1,"Coke", 10),
    PEPSI(2,"Pepsi",10),
    SODA (3,"Soda",20),
    UNKNOWN(0, "Unknown", 0);

    private final int option;
    private final String name;
    private final int price;

    Product(int option, String name, int price) {
        this.option = option;
        this.name = name;
        this.price = price;
    }

    public int getOption() {
        return this.option;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return this.price;
    }
}
