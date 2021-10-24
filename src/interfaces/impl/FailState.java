package interfaces.impl;

import interfaces.State;

public class FailState implements State {
    /* This interface is to apply State Design Pattern */
    @Override
    public void displayPaymentResult() {
        System.out.print("Order failed: ");
    }
}
