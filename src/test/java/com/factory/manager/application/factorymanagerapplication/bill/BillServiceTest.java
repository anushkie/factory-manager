package com.factory.manager.application.factorymanagerapplication.bill;

import com.factory.manager.application.factorymanagerapplication.billAPI.Bill;
import com.factory.manager.application.factorymanagerapplication.billAPI.BillDao;
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
public class BillServiceTest {

    BillService billService;

    @Mock
    BillDao billDao;

    @BeforeEach
    void setUp() {
        billService = new BillService(billDao);
    }

    @Test
    public void getOrderDetailsOfTheSavedBills() {
        List<OrderLine> mockedOrderLists = new ArrayList<>();
        OrderLine order1 = new OrderLine(17, 12,20,25,10, 15);
        OrderLine order2 = new OrderLine(17, 100, 30, 25, 0, 25);
        mockedOrderLists.add(order1);
        mockedOrderLists.add(order2);
        Mockito.when(billDao.getOrderDetails()).thenReturn(mockedOrderLists);
        List list = billService.getOrderDetails();
        Assert.assertEquals(mockedOrderLists, list);
    }

    @Test
    public void getSavedBillsShouldReturnTheStoredBillsOfExistingCustomers() {

        List<Bill> mockedBillList = new ArrayList<>();
        Bill bill1 = new Bill(11, 1, 50, 10);
        Bill bill2 = new Bill(13, 3, 100, 20);
        Bill bill3 = new Bill(15, 5, 80, 10);
        Bill bill4 = new Bill(17, 7, 55, 25);
        mockedBillList.add(bill1);
        mockedBillList.add(bill2);
        mockedBillList.add(bill3);
        mockedBillList.add(bill4);
        Mockito.when(billDao.getAllBills()).thenReturn(mockedBillList);
        List list = billService.getSavedBills();
        Assert.assertEquals(mockedBillList, list);
    }

    @Test
    public void printBillForAGivenIdShouldReturnOrderDetailsForAGivenBillId() {
        List<OrderLine> mockedOrderList = new ArrayList<>();
        OrderLine order1 = new OrderLine(17, 12,20,25,10, 15);
        OrderLine order2 = new OrderLine(17, 100, 30, 25, 0, 25);
        mockedOrderList.add(order1);
        mockedOrderList.add(order2);
        Mockito.when(billDao.getBillBasedOnBillID(17)).thenReturn(mockedOrderList);
        List list = billService.printBillForAGivenId(17);
        Assert.assertEquals(mockedOrderList,list);
    }

}
