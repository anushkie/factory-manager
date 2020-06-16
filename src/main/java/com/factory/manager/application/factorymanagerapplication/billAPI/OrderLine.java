package com.factory.manager.application.factorymanagerapplication.billAPI;

public class OrderLine {

    private int billNumber;
    private int productId;
    private int quantity;
    private int price;
    private int discount;
    private int finalPrice;

    //private Product product;

    public OrderLine(int billNumber, int productId, int qty, int price, int discount, int finalPrice) {
        this.billNumber = billNumber;
        this.productId = productId;
        this.quantity = qty;
        this.price = price;
        this.discount = discount;
        this.finalPrice = finalPrice;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String toString() {
        return String.format("Bill[bill number=%d, product id=%d, quantity=%d, price=%d, discount=%d, fina price=%d]",
                billNumber, price, quantity, price, discount, finalPrice);
    }

}
