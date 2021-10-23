package controller;

import entities.cashnote.CashNoteBundle;
import entities.product.Product;
import interfaces.Calculator;
import interfaces.CashbackGiver;
import interfaces.Releasable;


import exceptions.InsufficientMoneyException;
import interfaces.impl.CalculatorImpl;

import interfaces.impl.CashBackGiverImpl;
import interfaces.impl.ProductReleaser;

import request.PurchaseRequest;
public class MachineController {
    private final Calculator calculator = new CalculatorImpl();
    private final CashbackGiver cashBackGiver = new CashBackGiverImpl();
    private final Releasable productReleaser = new ProductReleaser();

    public int getChange(PurchaseRequest request, CashNoteBundle bundle){
        int totalPayment = calculator.calculateTotalPayment(request);
        int totalMoneyInput = calculator.calculateTotalMoneyInput(bundle);
        if (!isMoneyEnoughToOrder(totalPayment, totalMoneyInput)){
            throw new InsufficientMoneyException("Not enough money to order");
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


    public int calculateTotalMoneyInput(CashNoteBundle bundle) {
        return calculator.calculateTotalMoneyInput(bundle);
    }

    private boolean isMoneyEnoughToOrder(int totalPayment, int totalMoneyInput){
        return totalMoneyInput > totalPayment;
    }
}
