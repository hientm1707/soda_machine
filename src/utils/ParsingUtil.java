package utils;

import entities.cashnote.CashNote;
import entities.cashnote.CashNoteBundle;

import java.util.List;

public class ParsingUtil {
    public static CashNoteBundle parseToCashNoteBundle(List<Integer> cashNotes){
        int numOfTenNotes = 0;
        int numOfTwentyNotes = 0;
        int numOfFiftyNotes = 0;
        int numOfOneHundredNotes = 0;
        int numOfTwoHundredNotes = 0;

        for (Integer note : cashNotes){
          if (note.equals(CashNote.TEN.getValue())) {
              numOfTenNotes++;
          } else if (note.equals(CashNote.TWENTY.getValue())){
              numOfTwentyNotes++;
          } else if (note.equals(CashNote.FIFTY.getValue())){
              numOfFiftyNotes++;
          } else if (note.equals(CashNote.ONE_HUNDRED.getValue())){
              numOfOneHundredNotes++;
          } else if (note.equals(CashNote.TWO_HUNDRED.getValue())){
              numOfTwoHundredNotes++;
          }
        }
        return new CashNoteBundle(numOfTenNotes, numOfTwentyNotes, numOfFiftyNotes, numOfOneHundredNotes, numOfTwoHundredNotes);
    }
}
