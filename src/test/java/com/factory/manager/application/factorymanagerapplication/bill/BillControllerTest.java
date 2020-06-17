package com.factory.manager.application.factorymanagerapplication.bill;

import com.factory.manager.application.factorymanagerapplication.billAPI.Bill;
import com.factory.manager.application.factorymanagerapplication.billAPI.BillController;
import com.factory.manager.application.factorymanagerapplication.billAPI.BillService;
import com.factory.manager.application.factorymanagerapplication.billAPI.OrderLine;
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
public class BillControllerTest {

    BillController billController;

    @Mock
    BillService billService;

    @BeforeEach
    void setUp() {
        billController = new BillController(billService);
    }

    @Test
    void printOrderDetailsShouldShowTheSavedOrders() {
        List<OrderLine> mockedOrderLists = new ArrayList<>();
        OrderLine order1 = new OrderLine(17, 12,20,25,10, 15);
        OrderLine order2 = new OrderLine(17, 100, 30, 25, 0, 25);
        mockedOrderLists.add(order1);
        mockedOrderLists.add(order2);
        Mockito.when(billService.getOrderDetails()).thenReturn(mockedOrderLists);
        List list = billController.getOrderDetails();
        Assert.assertEquals(mockedOrderLists, list);
    }

    @Test
    void printBillShouldReturnTheStoredBillsOfExistingCustomers() {

        List<Bill> mockedBillList = new ArrayList<>();
        Bill bill1 = new Bill(11,1,50,10);
        Bill bill2 = new Bill(13, 3,100, 20);
        Bill bill3 = new Bill(15,5,80,10);
        Bill bill4 = new Bill(17,7,55,25);
        mockedBillList.add(bill1);
        mockedBillList.add(bill2);
        mockedBillList.add(bill3);
        mockedBillList.add(bill4);
        Mockito.when(billService.getSavedBills()).thenReturn(mockedBillList);
        List list = billController.getAllBill();
        Assert.assertEquals(mockedBillList, list);
    }

    @Test
    void printBillBasedOnCustomerDetailsShouldReturnOrderDetailsForGivenBillId() {
        List<OrderLine> mockedOrderList = new ArrayList<>();
        OrderLine order1 = new OrderLine(17, 12,20,25,10, 15);
        OrderLine order2 = new OrderLine(17, 100, 30, 25, 0, 25);
        mockedOrderList.add(order1);
        mockedOrderList.add(order2);
        Mockito.when(billService.printBillForAGivenId(17)).thenReturn(mockedOrderList);
        List list = billController.getBillBasedOnCustomerDetails(17);
        Assert.assertEquals(mockedOrderList,list);
    }
}
