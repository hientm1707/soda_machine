package interfaces.impl;

import interfaces.CashbackGiver;

public class CashBackGiverImpl implements CashbackGiver {
    @Override
    public void deliverChangeToUser(int value) {
        /* Pretend to deliver cashback to user */
        if (value == 0) {
            return;
        }
        System.out.println("Delivering change: " + value*1000 + " VND...");
        System.out.println("================CASHBACK DELIVERED SUCCESSFULLY================");
    }

    @Override
    public void deliverRefundToUser(int value) {
        /* Pretend to deliver refund to user */
        System.out.println("Delivering refund: " + value*1000 + " VND...");
        System.out.println("================REFUND DELIVERED SUCCESSFULLY================");
    }

}
