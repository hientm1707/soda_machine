package interfaces;

import entities.cashnote.CashNoteBundle;
import request.PurchaseRequest;

public interface MachineUI {
    void displayGreetingMessage();
    void displayAvailableProducts();
    void displayMoneyInputPrompt();
    void displayOptionInputPrompt();
    void displayQuantityInputPrompt();
    void displayExceptionMessage();
    void displayRunAgainPrompt();
    void displayNumberOfNotesPrompt();
    void displayCashNotePrompt();
    void displayExceptionCauseMessage(String message);
    void displayPaymentResult(boolean success);
    void handlePurchaseRequest(PurchaseRequest request, CashNoteBundle cashNoteBundle);
}
