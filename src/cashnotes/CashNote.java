package cashnotes;

public enum CashNote {
    TEN(10),
    TWENTY(20),
    FIFTY( 50),
    ONE_HUNDRED(100),
    TWO_HUNDRED(200);

    private int value;

    CashNote(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
