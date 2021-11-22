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
        final String SQL_RUN_SCRIPT = "cryptoinvesting-test-schema.sql";
        jdbcTest.update(SQL_RUN_SCRIPT);
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
        portfolio1.setUserId(user1.getUserId());
        portfolioTest.addPortfolio(portfolio1);

        //add order one
        Orders order1 = new Orders();
        order1.setPortfolioId(portfolio1.getPortfolioId());
        order1.setCryptoName("BTC");


        //get the order

        //test the info in the order
    }

}