package com.factory.manager.application.factorymanagerapplication.billAPI;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BillDao {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public BillDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public List<OrderLine> getOrderDetails() {
        return jdbcTemplate.query("select * from order_line", new RowMapper<OrderLine>() {
            @Override
            public OrderLine mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrderLine order = new OrderLine(rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                order.toString();
                return order;
            }
        });
    }

    public List<Bill> getAllBills() {
        return jdbcTemplate.query("select * from bill", new RowMapper<Bill>() {
            @Override
            public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
                Bill bill = new Bill(rs.getInt(1), rs.getInt(2), rs.getInt("price"), rs.getInt("discount"));
                return bill;
            }
        });
    }


    public List<OrderLine> getBillBasedOnBillID(int billId) {

        return jdbcTemplate.query("select * from order_line where bill_id = ?", new Object[] {billId}, new RowMapper<OrderLine> (){
            @Override
            public OrderLine mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrderLine order = new OrderLine(rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                return order;
            }
        });
    }
}
