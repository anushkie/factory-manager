
package com.factory.manager.application.factorymanagerapplication.billAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {

    BillDao billDao;

    @Autowired
    public BillService(BillDao billDao) {
        this.billDao = billDao;
    }

    public List<OrderLine> getOrderDetails() {
       return billDao.getOrderDetails();
    }

    public List<Bill> getSavedBills() {
        return billDao.getAllBills();
    }


    public List<OrderLine> printBillForAGivenId(int billID) {
        return billDao.getBillBasedOnCustomer(billID);
    }




}

