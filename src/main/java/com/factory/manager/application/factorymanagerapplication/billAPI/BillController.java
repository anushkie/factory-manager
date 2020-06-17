
package com.factory.manager.application.factorymanagerapplication.billAPI;

import com.factory.manager.application.factorymanagerapplication.customerAPI.Customer;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class BillController {

    BillService billService;

    @Autowired
    public BillController(BillService billService ) {
        this.billService = billService;
    }

    @GetMapping("/order")
    public List<OrderLine> getOrderDetails() {
        return billService.getOrderDetails();
    }

    @GetMapping("/bills")
    public List<Bill> getAllBill() {
        return billService.getSavedBills();
    }

    @GetMapping("/bills/{billId}")
    public List<OrderLine> getBillBasedOnCustomerDetails(@PathVariable int billId) {
        return billService.printBillForAGivenId(billId);
    }

    @GetMapping("/pdf")
    public void exportBillAsPDF() {
    }

}
