package entities.cashnote;

public class CashNoteBundle {
    private final int numOfTenNotes;
    private final int numOfTwentyNotes;
    private final int numOfFiftyNotes;
    private final int numOfOneHundredNotes;
    private final int numOfTwoHundredNotes;

    public CashNoteBundle(int numOfTenNotes, int numOfTwentyNotes, int numOfFiftyNotes, int numOfOneHundredNotes, int numOfTwoHundredNotes) {
        this.numOfTenNotes = numOfTenNotes;
        this.numOfTwentyNotes = numOfTwentyNotes;
        this.numOfFiftyNotes = numOfFiftyNotes;
        this.numOfOneHundredNotes = numOfOneHundredNotes;
        this.numOfTwoHundredNotes = numOfTwoHundredNotes;
    }

    public int getNumOfTenNotes() {
        return numOfTenNotes;
    }


    public int getNumOfTwentyNotes() {
        return numOfTwentyNotes;
    }


    public int getNumOfFiftyNotes() {
        return numOfFiftyNotes;
    }


    public int getNumOfOneHundredNotes() {
        return numOfOneHundredNotes;
    }


    public int getNumOfTwoHundredNotes() {
        return numOfTwoHundredNotes;
    }

}
