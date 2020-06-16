package com.factory.manager.application.factorymanagerapplication.customerAPI;

import com.factory.manager.application.factorymanagerapplication.billAPI.OrderLine;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/count")
  //  @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)
    public int count(){
        int result = customerService.countCustomers();
        return result;
    }

    @GetMapping("update")
    public void update() {
        customerService.updateCustomer(1, "Anushka B");
    }

    @PostMapping("create")
    public void createCustomer() {
        customerService.createAnewCustomer(10, "Sneh");
    }

    @GetMapping("read")
    public List<Customer> printCustomer() {
        return customerService.readCustomer();
    }

    @GetMapping("delete")
    public void deleteCustomer(){
        customerService.deleteAcustomer(7);
    }

    @GetMapping("/custBill/{customerId}")
    public List<OrderLine> printBill(@PathVariable int customerId) {
        return customerService.printCustomerBill(customerId);
    }

}
