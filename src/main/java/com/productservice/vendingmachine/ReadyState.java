package com.productservice.vendingmachine;

public class ReadyState implements State {
    private VendingMachine vendingMachine;
    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        this.vendingMachine.setCollectedCash(cash);
    }

    @Override
    public void dispenseChange(String productCode) {
        this.vendingMachine.setState(new DispenseChangeState(this.vendingMachine));
        this.vendingMachine.dispenseChange(productCode);
    }

    @Override
    public void dispenseItem(String productCode) {

    }

    @Override
    public void cancelTransaction() {

    }
}
