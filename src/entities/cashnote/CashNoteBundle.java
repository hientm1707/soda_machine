package entities.cashnote;

public class CashNoteBundle {
    private int numOfTenNotes;
    private int numOfTwentyNotes;
    private int numOfFiftyNotes;
    private int numOfOneHundredNotes;
    private int numOfTwoHundredNotes;

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

    public void setNumOfTenNotes(int numOfTenNotes) {
        this.numOfTenNotes = numOfTenNotes;
    }

    public int getNumOfTwentyNotes() {
        return numOfTwentyNotes;
    }

    public void setNumOfTwentyNotes(int numOfTwentyNotes) {
        this.numOfTwentyNotes = numOfTwentyNotes;
    }

    public int getNumOfFiftyNotes() {
        return numOfFiftyNotes;
    }

    public void setNumOfFiftyNotes(int numOfFiftyNotes) {
        this.numOfFiftyNotes = numOfFiftyNotes;
    }

    public int getNumOfOneHundredNotes() {
        return numOfOneHundredNotes;
    }

    public void setNumOfOneHundredNotes(int numOfOneHundredNotes) {
        this.numOfOneHundredNotes = numOfOneHundredNotes;
    }

    public int getNumOfTwoHundredNotes() {
        return numOfTwoHundredNotes;
    }

    public void setNumOfTwoHundredNotes(int numOfTwoHundredNotes) {
        this.numOfTwoHundredNotes = numOfTwoHundredNotes;
    }
}
