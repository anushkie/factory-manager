package com.factory.manager.application.factorymanagerapplication.customerAPI;

import com.factory.manager.application.factorymanagerapplication.billAPI.Bill;
import com.factory.manager.application.factorymanagerapplication.billAPI.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDAO {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public CustomerDAO(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    public int countCustomer() {
        int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM CUSTOMER", Integer.class);
        return result;
    }


    public void update(int id, String nameToBeUpdated) {
         jdbcTemplate.update(
                 "UPDATE customer SET `customer_name` = ? WHERE (`id` = ?)", nameToBeUpdated, id);
    }


    public void createAnewCustomer(int newId, String newName) {
        
        jdbcTemplate.update(
        "INSERT INTO CUSTOMER VALUES (?, ?)", newId, newName);
    }

    public String getCustomerById(Integer id) {
        return jdbcTemplate.queryForObject("select * from customer where id = ?", new Object[] {id},  new RowMapper<String>() {

            @Override
            public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                String name = resultSet.getString("customer_name");
                System.out.println("NAme of the customer received : " + name);
                return name;
            }
        });
    }

    public List<Customer> getCustomer() {
        return jdbcTemplate.query("select * from customer", new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Customer customer = new Customer(resultSet.getInt(1),resultSet.getString(2) );
                return customer;
            }
        });
    }

    public void deleteCustomer(int idToBeDeleted){
        jdbcTemplate.update("delete from customer where id = ?", idToBeDeleted);
    }

    public List<OrderLine> printBill(int customerID) {
        int billID = this.jdbcTemplate.queryForObject(
                "select id from bill where customer_id = ?",
                new Object[]{customerID}, Integer.class);

        return jdbcTemplate.query("select * from order_line where bill_id = ?", new Object[] {billID}, new RowMapper<OrderLine> (){
            @Override
            public OrderLine mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrderLine order = new OrderLine(rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                return order;
            }
        });
    }


/*
    public Customer findByCustomerId2(Long id) {

        String sql = "SELECT * FROM CUSTOMER WHERE ID = ?";

        return (Customer) jdbcTemplate.queryForObject(
			sql,
			new Object[]{id},
			new BeanPropertyRowMapper(Customer.class));

    }
*/
}
