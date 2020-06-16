package com.factory.manager.application.factorymanagerapplication.customer;

import com.factory.manager.application.factorymanagerapplication.customerAPI.Customer;
import com.factory.manager.application.factorymanagerapplication.customerAPI.CustomerDAO;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class CustomerDAOIntegrationTest {

    @Autowired
    CustomerDAO customerDAO;

    @Test
    void createAndViewACustomer() {
        System.out.println(customerDAO.countCustomer());
        customerDAO.createAnewCustomer(98,"jaja");
        List<Customer> customers = customerDAO.getCustomer();

        for (Customer customer : customers) {
            int customerId = customer.getId();
            String customerName = customer.getCustomerName();
            Assert.assertEquals(customerId,98);
            Assert.assertEquals(customerName, "jaja");
        }
    }

    @Test
    void updateAnExistingCustomer() {
        customerDAO.createAnewCustomer(98,"jaja");
        customerDAO.update(98, "juju");
        String customerName = customerDAO.getCustomerById(98);
        Assert.assertEquals(customerName, "juju");
    }

    @Test
    void deleteAnExistingCustomer() {
        customerDAO.createAnewCustomer(100, "Anushka");
        customerDAO.deleteCustomer(100);
        int customerCount = customerDAO.countCustomer();
        Assert.assertEquals(0, customerCount);
    }

}
