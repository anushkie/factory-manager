
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
    public List<OrderLine> printOrderDetails() {
        return billService.printOrderDetails();
    }

    @GetMapping("/bills")
    public List<Bill> printAllBill() {
        return billService.printBills();
    }

    @GetMapping("/bills/{billId}")
    public List<OrderLine> printBillBasedOnCustomerDetails(@PathVariable int billId) {
        return billService.printBill(billId);
    }

    @GetMapping("/pdf")
    public void exportBillAsPDF() {
    }

}
