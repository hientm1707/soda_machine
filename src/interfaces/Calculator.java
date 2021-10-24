package interfaces;

import entities.cashnote.CashNoteBundle;
import entities.request.PurchaseRequest;

public interface Calculator {
    int calculateTotalPayment(PurchaseRequest request);
    int calculateTotalMoneyInput(CashNoteBundle bundle);

}
