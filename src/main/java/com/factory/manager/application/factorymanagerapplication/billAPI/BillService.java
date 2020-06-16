
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

    public List<OrderLine> printOrderDetails() {
       return billDao.printOrderDetails();
    }

    public List<Bill> printBills() {
        return billDao.printBills();
    }


    public List<OrderLine> printBill(int billID) {
        return billDao.printBillBasedOnCustomer(billID);
    }


}

