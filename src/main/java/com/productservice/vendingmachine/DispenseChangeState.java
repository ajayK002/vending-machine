package com.productservice.vendingmachine;

public class DispenseChangeState implements State {
    private VendingMachine vendingMachine;

    DispenseChangeState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void collectCash(int cash) {
        throw new RuntimeException("Can not collect cash. Currently dispensing change.");
    }

    @Override
    public void dispenseChange(String productCode) {
        int change = this.vendingMachine.calculateChange(productCode);
        if(change<0){
            throw new RuntimeException("Insufficient cash entered. Please collect your cash " + this.vendingMachine.getCollectedCash());
        }
        System.out.println("Please collect your change " + change);
        this.vendingMachine.setState(new DispenseItemState(this.vendingMachine));
        this.vendingMachine.dispenseItem(productCode);
    }

    @Override
    public void dispenseItem(String productCode) {
        throw new RuntimeException("Can not dispense item. Currently dispensing change.");
    }

    @Override
    public void cancelTransaction() {

    }
}
