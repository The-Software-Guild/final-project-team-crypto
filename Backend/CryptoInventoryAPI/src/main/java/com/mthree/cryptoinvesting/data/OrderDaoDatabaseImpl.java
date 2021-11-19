package com.mthree.cryptoinvesting.data;

import com.mthree.cryptoinvesting.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoDatabaseImpl implements OrderDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Orders addOrder(Orders order) {
        return null;
    }

    @Override
    public Orders getOrderById(int orderId) {
        return null;
    }

    @Override
    public List<Orders> getAllOrdersByPortfolioId(int portfolioId) {
        return null;
    }

    @Override
    public List<Orders> getAllOrders() {
        return null;
    }
}
