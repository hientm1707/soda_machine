package interfaces;

import entities.cashnote.CashNoteBundle;
import entities.request.PurchaseRequest;

import java.util.List;

public interface MachineInterface {
    void displayGreetingMessage();
    void displayAvailableProducts();
    void displayMoneyInputPrompt();
    void displayOptionInputPrompt();
    void displayQuantityInputPrompt();
    void displayInputExceptionMessage();
    void displayRunAgainPrompt();
    void displayNumberOfNotesPrompt();
    void displayCashNotePrompt();
    void displayMessage(String message);
    void displayPaymentResult();
    void handlePurchaseRequest(PurchaseRequest request, CashNoteBundle cashNoteBundle);
    void receiveNote(int note);
    void clearMoneyBuffer();
    void setState(boolean b);
    List<Integer> getInputtedCashNotes();
}
