package utils;

import cashnotes.CashNoteBundle;

import java.util.List;

public class ParsingUtil {
    public static CashNoteBundle parseListOfCashNotesToCashNoteBundle(List<Integer> cashNotes){
        int numOfTenNotes = 0;
        int numOfTwentyNotes = 0;
        int numOfFiftyNotes = 0;
        int numOfOneHundredNotes = 0;
        int numOfTwoHundredNotes = 0;
        for (Integer note : cashNotes){
          if (note.equals(10)) {
              numOfTenNotes++;
          } else if (note.equals(20)){
              numOfTwentyNotes++;
          } else if (note.equals(50)){
              numOfFiftyNotes++;
          } else if (note.equals(100)){
              numOfOneHundredNotes++;
          } else if (note.equals(200)){
              numOfTwoHundredNotes++;
          }
        }
        return new CashNoteBundle(numOfTenNotes, numOfTwentyNotes, numOfFiftyNotes, numOfOneHundredNotes, numOfTwoHundredNotes);
    }
}
