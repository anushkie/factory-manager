package com.factory.manager.application.factorymanagerapplication.item_type;

import com.factory.manager.application.factorymanagerapplication.productAPI.Product;

public class ItemType {

    private Product product;

    private int productID;
    private int prize;
    private String type;

    public ItemType(Product product, int productID) {
        this.product = product;
        this.productID = product.getProductId();
    }





}
