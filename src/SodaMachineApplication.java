import entities.cashnote.CashNoteBundle;
import interfaces.MachineInterface;
import interfaces.impl.MachineInterfaceImpl;
import entities.product.ProductFactory;
import entities.request.PurchaseRequest;
import utils.ParsingUtil;
import utils.Validator;

import java.util.*;

public class SodaMachineApplication {
    public static void main (String[] args){
        System.out.println("This is a simulator of a soda selling machine ... MOMO TEST");
        Scanner scanner = new Scanner(System.in);
        MachineInterface machineInterface = new MachineInterfaceImpl();
        while (true) { /* Loop forever */

            /* Display screen */
            machineInterface.displayGreetingMessage();
            machineInterface.displayAvailableProducts();

            /* User choose entities.product and entities.product to buy */
            machineInterface.displayOptionInputPrompt();
            int option = scanner.nextInt();
            machineInterface.displayQuantityInputPrompt();
            int quantity = scanner.nextInt();

            /* Validate input */
            try {
                Validator.validateOptionAndQuantity(option, quantity);
            } catch (Exception e) {
                machineInterface.displayInputExceptionMessage();
                machineInterface.displayMessage(e.getMessage());
                machineInterface.displayRunAgainPrompt();
                continue;
            }

            /* Input cash notes  */
            /* Only accept 10, 20, 50, 100, 200 (thousand) VND */
            machineInterface.displayMoneyInputPrompt();
            machineInterface.displayNumberOfNotesPrompt();
            int numOfNotesInputting = scanner.nextInt();
            machineInterface.displayCashNotePrompt();

            /* receiveNotes */
            for (int i = 0; i < numOfNotesInputting; i++) {
                machineInterface.receiveNote(scanner.nextInt());
            }

            /* Parse to easy-to-handle objects */
            CashNoteBundle cashNoteBundle = ParsingUtil.parseToCashNoteBundle((machineInterface.getInputtedCashNotes()));
            PurchaseRequest purchaseRequest = new PurchaseRequest(ProductFactory.createProduct(option), quantity);

            /* Begin handling request */
            try {
                machineInterface.handlePurchaseRequest(purchaseRequest, cashNoteBundle);
            } catch (Exception e) {
                machineInterface.setState(false);
                machineInterface.displayPaymentResult();
                machineInterface.displayMessage(e.getMessage());
                machineInterface.clearMoneyBuffer();
                continue;
            }
            machineInterface.setState(true);
            machineInterface.displayPaymentResult();
            machineInterface.clearMoneyBuffer();
        }
    }
}
