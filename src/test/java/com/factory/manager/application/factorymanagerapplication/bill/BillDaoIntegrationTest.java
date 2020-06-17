package com.factory.manager.application.factorymanagerapplication.bill;

import com.factory.manager.application.factorymanagerapplication.billAPI.BillDao;
import com.factory.manager.application.factorymanagerapplication.billAPI.OrderLine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class BillDaoIntegrationTest {

    @Autowired
    BillDao billDao;

    @Test
    void getOrderDetails() {
        List<OrderLine> orders = billDao.getOrderDetails();
        for(OrderLine orderLine : orders) {

        }
    }
}
