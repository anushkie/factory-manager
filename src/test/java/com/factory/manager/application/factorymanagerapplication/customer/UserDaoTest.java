package com.factory.manager.application.factorymanagerapplication.customer;

import com.factory.manager.application.factorymanagerapplication.customerAPI.CustomerDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
public class UserDaoTest {

    @Mock
   private JdbcTemplate jdbcTemplate;
    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    public void whenMockJdbcTemplate_thenReturnCorrectCustomerCount() {
        CustomerDAO customerDAO = new CustomerDAO(jdbcTemplate, namedParameterJdbcTemplate);
        Mockito.when(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM CUSTOMER", Integer.class)).thenReturn(6);
    }


}
