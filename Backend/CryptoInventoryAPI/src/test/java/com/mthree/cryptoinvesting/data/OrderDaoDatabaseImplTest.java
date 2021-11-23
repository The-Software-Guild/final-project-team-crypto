/**
 * @author Chelsey
 * Tests the OrderDaoDatabaseImpl file.  You must run each test method
 * one by one in the order they are presented.
 */
package com.mthree.cryptoinvesting.data;
import com.mthree.cryptoinvesting.TestApplicationConfiguration;
import com.mthree.cryptoinvesting.model.Orders;
import com.mthree.cryptoinvesting.model.Portfolio;
import com.mthree.cryptoinvesting.model.Users;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

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
        Portfolio portfolio1 = portfolioTest.addPortfolio(user1);

        //add order one
        Orders order1 = new Orders();
        order1.setPortfolioId(portfolio1.getPortfolioId());
        order1.setCryptoName("BTC");
        order1.setPrice(12.50f);
        order1.setAmount(3);
        order1.setDatePurchased(LocalDateTime.now());
        orderTest.addOrder(order1);

        //get the order
        Orders retrievedOrder = orderTest.getOrderById(order1.getOrderId());

        //test the info in the order
        assertNotNull(retrievedOrder);
        assertEquals(order1.getOrderId(), retrievedOrder.getOrderId());
        assertEquals(order1.getAmount(), retrievedOrder.getAmount(),1e-15);
        assertEquals(order1.getPortfolioId(), retrievedOrder.getPortfolioId());
        assertEquals(order1.getCryptoName(), retrievedOrder.getCryptoName());
        assertEquals(order1.getPrice(), retrievedOrder.getPrice(),1e-15);
        assertEquals(order1.getDatePurchased(), retrievedOrder.getDatePurchased());

    }

    @Test
    public void testGetOrderById() {
            // Retrieving order from testAddGetOrder
            Orders order = orderTest.getOrderById(1);
            assertEquals(order.getOrderId(),1);
            assertEquals(order.getAmount(),3,1e-15);
            assertEquals(order.getPortfolioId(),1);
            assertEquals(order.getCryptoName(),"BTC");
            assertEquals(order.getPrice(),12.50f,1e-15);
            assertEquals(order.getDatePurchased() != null,true);
            assertEquals(order.getDateSold(),null);
    }

    @Test
    public void testGetAllOrdersByPortfolioId() {
        //add order one
        Orders order2 = new Orders();
        order2.setPortfolioId(1);
        order2.setCryptoName("ETH");
        order2.setPrice(50f);
        order2.setAmount(5);
        order2.setDatePurchased(LocalDateTime.now());
        orderTest.addOrder(order2);

        List<Orders> userOrders = orderTest.getAllOrdersByPortfolioId(1);

        for (Orders order : userOrders) {
            assertEquals(order.getPortfolioId(),1);
        }
    }

    @Test
    public void getAllOrders() {
        List<Orders> allOrders = orderTest.getAllOrders();

        assertEquals(allOrders.size(),2);

        Users user2 = new Users();
        user2.setUsername("hello.world");
        user2.setPassword("1soifsi");
        userTest.addUser(user2);

        //add portfolio
        Portfolio portfolio2 = portfolioTest.addPortfolio(user2);

        // Add a new order for a new user, check size and portfolio id.
        Orders order3 = new Orders();
        order3.setPortfolioId(user2.getUserId());
        order3.setCryptoName("ADA");
        order3.setPrice(100f);
        order3.setAmount(2);
        order3.setDatePurchased(LocalDateTime.now());
        orderTest.addOrder(order3);

        allOrders = orderTest.getAllOrders();

        assertEquals(allOrders.size(),3);
    }

    @Test
    public void testRemoveOrder() {
        Orders order = orderTest.getOrderById(1);
        Orders removed = orderTest.removeOrder(order);

        List<Orders> allOrders = orderTest.getAllOrders();

        for (Orders o : allOrders) {
            if (o.getOrderId() == 1) {
                assertEquals(o.getDateSold() != null, true);
            } else {
                assertEquals(o.getDateSold() == null, true);
            }
        }

    }
}