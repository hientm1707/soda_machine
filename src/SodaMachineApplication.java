import entities.cashnote.CashNoteBundle;
import interfaces.MachineUI;
import interfaces.impl.MachineUIImpl;
import entities.product.ProductFactory;
import request.PurchaseRequest;
import utils.ParsingUtil;
import utils.Validator;

import java.util.*;

public class SodaMachineApplication {
    public static void main (String[] args){
        System.out.println("This is a simulator of a soda selling machine .....");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            /* Display screen */
            MachineUI machineUI = new MachineUIImpl();
            machineUI.displayGreetingMessage();
            machineUI.displayAvailableProducts();

            /* User choose entities.product and entities.product to buy */
            machineUI.displayOptionInputPrompt();
            int option = scanner.nextInt();
            machineUI.displayQuantityInputPrompt();
            int quantity = scanner.nextInt();

            try {
                Validator.validateOptionAndQuantity(option, quantity);
            } catch (Exception e) {
                machineUI.displayExceptionMessage();
                machineUI.displayExceptionCauseMessage(e.getMessage());
                machineUI.displayRunAgainPrompt();
                continue;
            }
            /* Input cash notes  */
            /* Only accept 10, 20, 50, 100, 200 K VND */
            machineUI.displayMoneyInputPrompt();
            machineUI.displayNumberOfNotesPrompt();
            int numOfNotesInputting = scanner.nextInt();
            machineUI.displayCashNotePrompt();

            List<Integer> inputCashNotes = new LinkedList<>();

            for (int i = 0; i < numOfNotesInputting; i++) {
                inputCashNotes.add(scanner.nextInt());
            }

            CashNoteBundle cashNoteBundle = ParsingUtil.parseListOfCashNotesToCashNoteBundle(inputCashNotes);
            PurchaseRequest purchaseRequest = new PurchaseRequest(ProductFactory.createProduct(option), quantity);

            try {
                machineUI.handlePurchaseRequest(purchaseRequest, cashNoteBundle);
            } catch (Exception e) {
                machineUI.displayPaymentResult(false);
                machineUI.displayExceptionCauseMessage(e.getMessage());
                continue;
            }

            machineUI.displayPaymentResult(true);
        }
    }
}
