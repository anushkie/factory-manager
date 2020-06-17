package com.factory.manager.application.factorymanagerapplication.bill;

import com.factory.manager.application.factorymanagerapplication.billAPI.BillDao;
import com.factory.manager.application.factorymanagerapplication.billAPI.BillService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

    }

}
