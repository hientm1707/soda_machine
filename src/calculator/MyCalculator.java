package calculator;
import cashnotes.CashNote;
import cashnotes.CashNoteBundle;
import request.PurchaseRequest;
import exception.NotEnoughMoneyException;

public class MyCalculator implements Calculator{
    @Override
    public int calculateTotalPayment(PurchaseRequest request) {
        return request.getQuantity() * request.getProduct().getPrice();
    }

    @Override
    public int calculateChange(PurchaseRequest request, CashNoteBundle bundle) {
        int change = calculateTotalMoneyInput(bundle) - calculateTotalPayment(request);
        if (change < 0){
            throw new NotEnoughMoneyException("Not enough money");
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
