package com.factory.manager.application.factorymanagerapplication.billAPI;

import com.factory.manager.application.factorymanagerapplication.customerAPI.Customer;

public class Bill {

    private int billNumber;

    private int customerID;

    private int price;

    private int discount;


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Bill(int billNumber, int customerID, int price, int discount) {
        this.billNumber = billNumber;
        this.customerID = customerID;
        this.price = price;
        this.discount = discount;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
