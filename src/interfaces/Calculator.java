package interfaces;

import entities.cashnote.CashNoteBundle;
import request.PurchaseRequest;

public interface Calculator {
    int calculateTotalPayment(PurchaseRequest request);
    int calculateTotalMoneyInput(CashNoteBundle bundle);

}
