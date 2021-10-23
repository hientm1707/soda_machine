import cashnotes.CashNoteBundle;
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
    void handlePurchaseRequest(PurchaseRequest request, CashNoteBundle cashNoteBundle);
    void displayPaymentResult(boolean success);
}
