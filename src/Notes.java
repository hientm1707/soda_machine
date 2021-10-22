public enum Notes {
    TEN(10000),
    TWENTY(20000),
    FIFTY( 50000),
    ONEHUNDRED(100000),
    TWOHUNDRED(200000);

    private int value;

    Notes(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
