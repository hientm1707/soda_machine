package interfaces.impl;

import interfaces.State;

public class SuccessState implements State {
    /* This interface is to apply State Design Pattern */
    @Override
    public void displayPaymentResult() {
        System.out.println("*********************************************Order completed!********************************************************");
    }
}
