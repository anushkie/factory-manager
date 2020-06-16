package com.factory.manager.application.factorymanagerapplication.customer;

import com.factory.manager.application.factorymanagerapplication.customerAPI.Customer;
import com.factory.manager.application.factorymanagerapplication.customerAPI.CustomerController;
import com.factory.manager.application.factorymanagerapplication.customerAPI.CustomerService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    CustomerController customerController;

    @Mock
    CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerController = new CustomerController(customerService);
    }

    @Test
    void countTheCustomers() {
        Mockito.when(customerService.countCustomers()).thenReturn(6);
        int count = customerController.count();
        Assert.assertEquals(6, count);
    }

    @Test
    void updateAcustomer() {
        customerController.update();
        Mockito.verify(customerService).updateCustomer(1, "Anushka B");
    }

    @Test
    void createAcustomer() {
        customerController.createCustomer();
        Mockito.verify(customerService).createAnewCustomer(10, "Sneh");
    }

    @Test
    void deleteAcustomer() {
        customerController.deleteCustomer();
        Mockito.verify(customerService).deleteAcustomer(7);
    }

    @Test
    void readAcustomer() {
        List<Customer> mockedCustomerlist = new ArrayList<Customer>();
        Customer c1 = new Customer(1, "anushka");
        Customer c2 = new Customer(2, "Sneh");
        Customer c3 = new Customer(3, "Jiro");
        mockedCustomerlist.add(c1);
        mockedCustomerlist.add(c2);
        mockedCustomerlist.add(c3);
        Mockito.when(customerController.printCustomer()).thenReturn(mockedCustomerlist);
        List list = customerService.readCustomer();
        Assert.assertEquals(mockedCustomerlist, list);
    }
}
