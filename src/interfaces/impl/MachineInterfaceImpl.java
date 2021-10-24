package interfaces.impl;

import controller.MachineController;
import entities.cashnote.CashNoteBundle;
import entities.product.Product;
import exceptions.UserCancelException;
import interfaces.MachineInterface;
import interfaces.State;
import request.PurchaseRequest;
import java.util.Arrays;
import java.util.Scanner;

public class MachineInterfaceImpl implements MachineInterface {


    private State state;

    private final MachineController controller = new MachineController();

    private void setState(boolean state) {
        this.state = state ? new SuccessState() : new FailState();
    }

    @Override
    public void displayGreetingMessage() {
        System.out.println("***** Greetings from Soda Machine *****");
    }

    @Override
    public void displayAvailableProducts() {
        System.out.println("Here are our available products, please choose (option, quantity):");
        Arrays.stream(Product.values()).forEach(product -> {
            if (!product.equals(Product.UNKNOWN)) {
                System.out.println("Name: " + product.getName() + ","
                        + " Price: " + product.getPrice() * 1000 + " VND,"
                        + " Option number: " + product.getOption());
            }
        });
        System.out.println("** For safety issues, we only allow ordering at most 5 same products at a time **");
    }

    @Override
    public void displayMoneyInputPrompt() {
        System.out.println("*** Please input cash notes to the machine ***");
        System.out.println("** Note that we only accept 10, 20, 50, 100, 200 (thousand VND) notes, others will be ignored **");
    }

    @Override
    public void displayOptionInputPrompt() {
        System.out.print("Please choose your product (option number): ");
    }

    @Override
    public void displayQuantityInputPrompt() {
        System.out.print("Choose quantity of product (at most 5): ");
    }

    @Override
    public void displayExceptionMessage() {
        System.out.println("Please check your input! ");
    }

    @Override
    public void displayRunAgainPrompt() {
        System.out.println("Order failed... Restarting...!");
    }

    @Override
    public void displayNumberOfNotesPrompt() {
        System.out.print("How many cash notes you're going to input?: ");
    }

    @Override
    public void displayCashNotePrompt() {
        System.out.print("Please input your notes, space seperated (Example: 10 20 50 50) : ");
    }

    @Override
    public void displayExceptionCauseMessage(String message) {
        System.out.println(message);
    }


    @Override
    public void handlePurchaseRequest(PurchaseRequest request, CashNoteBundle cashNoteBundle) {
        System.out.println("==============================ORDER INFO====================================");
        int change = controller.getChange(request, cashNoteBundle);
        boolean userConfirmedOrder = promptConfirmation(request, cashNoteBundle);
        if (userConfirmedOrder){
            System.out.println("Order confirmed, releasing product and change if any...");
            controller.releaseProduct(request.getProduct(), request.getQuantity());
            controller.deliverChangeToUser(change);
            this.setState(true);
            return;
        }
        System.out.println("Order cancelled, refunding...");
        controller.deliverRefundToUser(controller.getTotalMoneyInput(cashNoteBundle));
        this.setState(false);
        throw new UserCancelException("User cancelled the request");
    }


    @Override
    public void displayPaymentResult() {
       this.state.displayPaymentResult();
    }

    private boolean promptConfirmation(PurchaseRequest request, CashNoteBundle cashNoteBundle) {
        System.out.println("You are ordering product: " + request.getProduct());
        System.out.println("Total money to pay: " + controller.getTotalPayment(request) * 1000 + " VND");
        System.out.println("You inputted: " + controller.getTotalMoneyInput(cashNoteBundle) * 1000 + " VND");
        System.out.println("Do you really want to proceed? (Y/N) ");
        /* Prompt user to choose confirm ordering */
        Scanner sc = new Scanner(System.in);
        while (true) {
            String confirmation = sc.next();
            if ("Y".equals(confirmation)) {
                return true;
            } else if ("N".equals(confirmation)) {
                return false;
            }
            System.out.print("Invalid input, please type either Y or N ");
        }
    }
}
