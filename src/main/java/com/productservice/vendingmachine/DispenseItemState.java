package com.productservice.vendingmachine;

public class DispenseItemState implements State {
    private VendingMachine vendingMachine;
    public DispenseItemState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        throw new RuntimeException("Can not collect cash. Currently dispensing item.");
    }

    @Override
    public void dispenseChange(String productCode) {
        throw new RuntimeException("Can not dispense change. Currently dispensing item.");
    }

    @Override
    public void dispenseItem(String productCode) {
        if(this.vendingMachine.checkProductCodeItem(productCode)){
            String productItem = this.vendingMachine.removeProduct(productCode);
            System.out.println("Your product " + productItem + " is dispensed and ready to be collected.");
        } else {
            throw new RuntimeException("Product is unavailable.");
        }
        this.vendingMachine.setState(new ReadyState(this.vendingMachine));
    }

    @Override
    public void cancelTransaction() {

    }
}
