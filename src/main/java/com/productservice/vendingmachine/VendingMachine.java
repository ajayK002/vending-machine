package com.productservice.vendingmachine;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class VendingMachine {
    private int collectedCash;
    private State state;
    private Map<String, Integer> productCodePricemap;
    private Map<String, Queue<String>> productCodeItemMap;

    public int getCollectedCash() {
        return collectedCash;
    }

    public void addCollectedCash(int collectedCash) {
        this.collectedCash += collectedCash;
    }

    public void setCollectedCash(int collectedCash) {
        this.collectedCash = collectedCash;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean checkProductCodeItem(String productCode) {
        return !productCodeItemMap.get(productCode).isEmpty();
    }

    public int getProductCodePrice(String productCode) {
        return this.productCodePricemap.get(productCode);
    }

    public VendingMachine dispenseChange(String productCode){
        this.state.dispenseChange(productCode);
        return this;
    }

    public VendingMachine dispenseItem(String productCode){
        this.state.dispenseItem(productCode);
        return this;
    }

    public void cancelTransaction(){
        this.state.cancelTransaction();
    }

    public int calculateChange(String productCode){
        return this.collectedCash - productCodePricemap.get(productCode);
    }

    public void setProductCodePriceMap(Map<String, Integer> productCodePricemap) {
        this.productCodePricemap = productCodePricemap;
    }

    public void setProductCodeItemMap(Map<String, Queue<String>> productCodeItemMap) {
        this.productCodeItemMap = productCodeItemMap;
    }

    public String removeProduct(String productCode){
        return this.productCodeItemMap.get(productCode).remove();
    }
}
