package com.mthree.cryptoinvesting.data;

import com.mthree.cryptoinvesting.TestApplicationConfiguration;
import com.mthree.cryptoinvesting.model.Orders;
import com.mthree.cryptoinvesting.model.Portfolio;
import com.mthree.cryptoinvesting.model.Users;
import org.apache.catalina.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class OrderDaoDatabaseImplTest {

    @Autowired
    private JdbcTemplate jdbcTest;

    @Autowired
    OrderDao orderTest;

    @Autowired
    PortfolioDao portfolioTest;

    @Autowired
    UserDao userTest;

    public OrderDaoDatabaseImplTest() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public void testAddGetOrder() {
        //add user
        Users user1 = new Users();
        user1.setUsername("john.smith");
        user1.setPassword("1234");
        userTest.addUser(user1);

        //add portfolio
        Portfolio portfolio1 = new Portfolio();
        portfolioTest.addPortfolio(user1);

        //add order one
        Orders order1 = new Orders();
        order1.setPortfolioId(portfolio1.getPortfolioId());
        order1.setCryptoName("BTC");
        order1.setPrice(12.50f);
        order1.setAmount(3);
        orderTest.addOrder(order1);

        //get the order
        Orders retrievedOrder = orderTest.getOrderById(order1.getOrderId());

        //test the info in the order
        assertNotNull(retrievedOrder);
        assertEquals(order1.getOrderId(), retrievedOrder.getOrderId());
        assertEquals(order1.getAmount(), retrievedOrder.getAmount());
        assertEquals(order1.getPortfolioId(), retrievedOrder.getPortfolioId());
        assertEquals(order1.getCryptoName(), retrievedOrder.getCryptoName());
        assertEquals(order1.getPrice(), retrievedOrder.getPrice());
        assertEquals(order1.getDatePurchased(), retrievedOrder.getDatePurchased());

    }

}