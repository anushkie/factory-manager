package com.factory.manager.application.factorymanagerapplication.bill;

import com.factory.manager.application.factorymanagerapplication.billAPI.BillController;
import com.factory.manager.application.factorymanagerapplication.billAPI.BillService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BillControllerTest {

    BillController billController;

    @Mock
    BillService billService;

    @BeforeEach
    void setUp() {
        billController = new BillController(billService);
    }


}
