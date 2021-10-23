package calculator;

import cashnotes.CashNoteBundle;
import request.PurchaseRequest;

public interface Calculator {
    int calculateTotalPayment(PurchaseRequest request);
    int calculateTotalMoneyInput(CashNoteBundle bundle);
    int calculateChange(PurchaseRequest request, CashNoteBundle bundle);
}
