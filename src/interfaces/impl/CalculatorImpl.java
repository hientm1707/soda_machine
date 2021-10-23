package interfaces.impl;
import interfaces.Calculator;
import entities.cashnote.CashNote;
import entities.cashnote.CashNoteBundle;
import request.PurchaseRequest;
import exceptions.InsufficientMoneyException;

public class CalculatorImpl implements Calculator {
    @Override
    public int calculateTotalPayment(PurchaseRequest request) {
        return request.getQuantity() * request.getProduct().getPrice();
    }

    @Override
    public int calculateChange(PurchaseRequest request, CashNoteBundle bundle) {
        int change = calculateTotalMoneyInput(bundle) - calculateTotalPayment(request);
        if (change < 0){
            throw new InsufficientMoneyException("Not enough money");
        }
        return change;
    }

    @Override
    public int calculateTotalMoneyInput(CashNoteBundle bundle) {
        return bundle.getNumOfTenNotes() * CashNote.TEN.getValue()
                + bundle.getNumOfTwentyNotes() * CashNote.TWENTY.getValue()
                + bundle.getNumOfFiftyNotes() * CashNote.FIFTY.getValue()
                + bundle.getNumOfOneHundredNotes() * CashNote.ONE_HUNDRED.getValue()
                + bundle.getNumOfTwoHundredNotes() * CashNote.TWO_HUNDRED.getValue();
    }

}
