import calculator.Calculator;
import calculator.MyCalculator;
import cashnotes.CashNoteBundle;
import exception.NotEnoughMoneyException;
import product.Product;
import request.PurchaseRequest;

public class MachineController {
    private final Calculator calculator = new MyCalculator();
    private final CashBackGiverImpl cashBackGiver = new CashBackGiverImpl();
    private final ProductReleaser productReleaser = new ProductReleaser();

    public int getChange(PurchaseRequest request, CashNoteBundle bundle){
        int totalPayment = calculator.calculateTotalPayment(request);
        int totalMoneyInput = calculator.calculateTotalMoneyInput(bundle);
        if (!isMoneyEnoughToOrder(totalPayment, totalMoneyInput)){
            throw new NotEnoughMoneyException("Not enough money to order");
        }
        return totalMoneyInput - totalPayment;
    }

    public void releaseProduct(Product product, int quantity){
        productReleaser.releaseProduct(product, quantity);
    }
    public void deliverChangeToUser(int value){
        cashBackGiver.deliverChangeToUser(value);
    }

    public void deliverRefundToUSer(int value){
        cashBackGiver.deliverRefundToUser(value);
    }
    public int calculateTotalPayment(PurchaseRequest request)
    {
        return calculator.calculateTotalPayment(request);
    }

    public int calculateChange(PurchaseRequest request, CashNoteBundle bundle) {
        return calculator.calculateChange(request, bundle);
    }

    public int calculateTotalMoneyInput(CashNoteBundle bundle) {
        return calculator.calculateTotalMoneyInput(bundle);
    }

    private boolean isMoneyEnoughToOrder(int totalPayment, int totalMoneyInput){
        return totalMoneyInput > totalPayment;
    }
}
