package interfaces.impl;

import interfaces.CashBackDelivery;

public class CashBackDeliveryImpl implements CashBackDelivery {
    @Override
    public void deliverChangeToUser(int value) {
        /* Pretend to deliver cashback to user */
        if (value == 0) {
            System.out.println("You have used up your money input, no change left");
            return;
        }
        System.out.println("Delivering change: " + value * 1000 + " VND...");
        System.out.println("Cashback delivered successfully...");
    }

    @Override
    public void deliverRefundToUser(int value) {
        /* Pretend to deliver refund to user */
        System.out.println("Delivering refund: " + value * 1000 + " VND...");
        System.out.println("================REFUND DELIVERED SUCCESSFULLY================");
    }

}
