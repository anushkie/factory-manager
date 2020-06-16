package com.factory.manager.application.factorymanagerapplication.customerAPI;

import com.factory.manager.application.factorymanagerapplication.billAPI.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    CustomerDAO dao;

    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.dao = customerDAO;
    }

    private static Logger LOGGER =  Logger.getLogger(CustomerService.class.getName());

    public int countCustomers() {
        int result = dao.countCustomer();
        if(result == 0) {
            LOGGER.info("This table is empty");
        }
        return result;
    }


    public void updateCustomer(int id, String nameToVeUpdated) {
        dao.update(id, nameToVeUpdated);
    }

    public void createAnewCustomer(int id, String newCustomer) {
        dao.createAnewCustomer(id, newCustomer);
    }

    public void deleteAcustomer(int idToBeDeleted) {
        //will first delete it from bill and other places where customer is der as a foreign key.
        dao.deleteCustomer(7);
    }

    public List<Customer> readCustomer() {
        return dao.getCustomer();
    }

    public List<OrderLine> printCustomerBill(int customerId) {
        return dao.printBill(customerId);
    }
}