package com.factory.manager.application.factorymanagerapplication.customerAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class Customer {

    private Integer id;
    private String customerName ;

    public Customer(Integer id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, customerName='%s']",
                id, customerName);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}
