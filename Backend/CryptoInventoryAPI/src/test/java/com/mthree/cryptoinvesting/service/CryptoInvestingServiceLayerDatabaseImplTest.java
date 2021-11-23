package com.mthree.cryptoinvesting.service;

import com.mthree.cryptoinvesting.TestApplicationConfiguration;
import com.mthree.cryptoinvesting.model.Orders;
import com.mthree.cryptoinvesting.model.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class CryptoInvestingServiceLayerDatabaseImplTest {

    @Autowired
    CryptoInvestingServiceLayer serviceTest;

    public CryptoInvestingServiceLayerDatabaseImplTest() {

    }

    @Test
    public void testAddNewUser() {
        //create user
        Users user1 = new Users();
        user1.setUsername("john.smith");
        user1.setPassword("1234abcd");

        //add user
        int user1Id = serviceTest.newUser(user1);

        user1.setUserId(user1Id);

        //create and add a second user
        Users user2 = new Users();
        user2.setUsername("jane.doe");
        user2.setPassword("abcd1234");

        int user2Id = serviceTest.newUser(user2);

        user2.setUserId(user2Id);

    }

    @Test
    public void testAll() {
        Orders order1 = new Orders();
        order1.setPortfolioId(1);
        order1.setCryptoName("BTC");
        order1.setPrice(12.36f);
        order1.setAmount(5);

        order1 = serviceTest.purchaseCrypto(order1);

        Orders order2 = new Orders();
        order2.setPortfolioId(2);
        order2.setCryptoName("ADA");
        order2.setPrice(5.69f);
        order2.setAmount(3.21f);

        order2 = serviceTest.purchaseCrypto(order2);

        List<Orders> allOrders = serviceTest.getAllOrders();

        //check all orders information after purchasing orders
        assertNotNull(allOrders);
        assertEquals(2, allOrders.size());

        Orders firstRetrieved = allOrders.get(0);

        assertNotNull(firstRetrieved);
        assertEquals(order1.getOrderId(), firstRetrieved.getOrderId());
        assertEquals(order1.getPortfolioId(), firstRetrieved.getPortfolioId());
        assertEquals(order1.getCryptoName(), firstRetrieved.getCryptoName());
        assertEquals(order1.getAmount(), firstRetrieved.getAmount(), 0.0f);
        assertEquals(order1.getPrice(), firstRetrieved.getPrice(), 0.0f);
        assertEquals(order1.getDatePurchased(), firstRetrieved.getDatePurchased());
        assertEquals(order1.getDateSold(), firstRetrieved.getDateSold());

        Orders secondRetrieved = allOrders.get(1);

        assertNotNull(firstRetrieved);
        assertEquals(order2.getOrderId(), secondRetrieved.getOrderId());
        assertEquals(order2.getPortfolioId(), secondRetrieved.getPortfolioId());
        assertEquals(order2.getCryptoName(), secondRetrieved.getCryptoName());
        assertEquals(order2.getAmount(), secondRetrieved.getAmount(),0.0f);
        assertEquals(order2.getPrice(), secondRetrieved.getPrice(), 0.0f);
        assertEquals(order2.getDatePurchased(), secondRetrieved.getDatePurchased());
        assertEquals(order2.getDateSold(), secondRetrieved.getDateSold());

        //sell an order and recheck information
        order1 = serviceTest.sellCrypto(order1);

        //check information
        List<Orders> allOrderInPortfolioOne = serviceTest.getAllOrdersByPortfolioId(1);

        assertNotNull(allOrderInPortfolioOne);
        assertEquals(1, allOrderInPortfolioOne.size());

        Orders theOrder = allOrderInPortfolioOne.get(0);
        assertNotNull(firstRetrieved);
        assertEquals(order1.getOrderId(), theOrder.getOrderId());
        assertEquals(order1.getPortfolioId(), theOrder.getPortfolioId());
        assertEquals(order1.getCryptoName(), theOrder.getCryptoName());
        assertEquals(order1.getAmount(), theOrder.getAmount(),0.0f);
        assertEquals(order1.getPrice(), theOrder.getPrice(), 0.0f);
        assertEquals(order1.getDatePurchased(), theOrder.getDatePurchased());
        assertEquals(order1.getDateSold(), theOrder.getDateSold());

    }



}
