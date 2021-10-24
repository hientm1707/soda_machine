package controller;

import entities.cashnote.CashNoteBundle;
import entities.product.Product;
import interfaces.Calculator;
import interfaces.CashBackDelivery;
import interfaces.Releasable;


import exceptions.InsufficientMoneyInputException;
import interfaces.impl.CalculatorImpl;

import interfaces.impl.CashBackDeliveryImpl;
import interfaces.impl.ProductReleaser;

import entities.request.PurchaseRequest;

public class MachineController {
    private final Calculator calculator = new CalculatorImpl();
    private final CashBackDelivery cashBackDelivery = new CashBackDeliveryImpl();
    private final Releasable productReleaser = new ProductReleaser();

    public int getChange(PurchaseRequest request, CashNoteBundle bundle){
        int totalPayment = calculator.calculateTotalPayment(request);
        int totalMoneyInput = calculator.calculateTotalMoneyInput(bundle);
        if (!isMoneyEnoughToOrder(totalPayment, totalMoneyInput)){
            throw new InsufficientMoneyInputException("Not enough money to order");
        }
        return totalMoneyInput - totalPayment;
    }

    public void releaseProduct(Product product, int quantity){
        productReleaser.releaseProduct(product, quantity);
    }

    public void deliverChangeToUser(int value){
        cashBackDelivery.deliverChangeToUser(value);
    }

    public void deliverRefundToUser(int value){
        cashBackDelivery.deliverRefundToUser(value);
    }

    public int getTotalPayment(PurchaseRequest request)
    {
        return calculator.calculateTotalPayment(request);
    }

    public int getTotalMoneyInput(CashNoteBundle bundle) {
        return calculator.calculateTotalMoneyInput(bundle);
    }

    private boolean isMoneyEnoughToOrder(int totalPayment, int totalMoneyInput){
        return totalMoneyInput >= totalPayment;
    }
}
