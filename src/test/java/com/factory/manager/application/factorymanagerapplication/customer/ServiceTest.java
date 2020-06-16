package com.factory.manager.application.factorymanagerapplication.customer;

import com.factory.manager.application.factorymanagerapplication.customerAPI.Customer;
import com.factory.manager.application.factorymanagerapplication.customerAPI.CustomerDAO;
import com.factory.manager.application.factorymanagerapplication.customerAPI.CustomerService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    CustomerService customerService;

    @Mock
    CustomerDAO customerDAO;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerDAO);
    }

    @Test
    void returnTheCountOfCustomers() {
        Mockito.when(customerDAO.countCustomer()).thenReturn(6);
        int count = customerService.countCustomers();
        Assert.assertEquals(6, count);
    }


    @Test
    void checkIfCustomerIsUpdated() {
        customerService.updateCustomer(2, "ijk");
       // Mockito.verify(customerDAO).update(Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(customerDAO).update(2, "ijk");
    }

    @Test
    void checkIfAnewCustomerIsCreated() {
        customerService.createAnewCustomer(100, "kuju");
        Mockito.verify(customerDAO).createAnewCustomer(100, "kuju");
    }

    @Test
    void checkIfACustomerIsDeleted() {
        customerService.deleteAcustomer(3);
        Mockito.verify(customerDAO).deleteCustomer(3);
    }

    @Test
    void readCustomer() {
        List<Customer> mockedCustomerlist = new ArrayList<Customer>();
        Customer c1 = new Customer(1, "anushka");
        Customer c2 = new Customer(2, "Sneh");
        Customer c3 = new Customer(3, "Jiro");
        mockedCustomerlist.add(c1);
        mockedCustomerlist.add(c2);
        mockedCustomerlist.add(c3);

        Mockito.when(customerService.readCustomer()).thenReturn(mockedCustomerlist);
        List list = customerDAO.getCustomer();
        Assert.assertEquals(mockedCustomerlist, list);
    }

}
