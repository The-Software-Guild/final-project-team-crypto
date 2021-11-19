package com.mthree.cryptoinvesting.service;

import com.mthree.cryptoinvesting.data.OrderDao;
import com.mthree.cryptoinvesting.data.PortfolioDao;
import com.mthree.cryptoinvesting.data.UserDao;
import com.mthree.cryptoinvesting.model.Orders;
import com.mthree.cryptoinvesting.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CryptoInvestingServiceLayerDatabaseImpl implements CryptoInvestingServiceLayer{

    @Autowired
    OrderDao orderDao;

    @Autowired
    PortfolioDao portfolioDao;

    @Autowired
    UserDao userDao;

    @Override
    public int newUser() {
        return 0;
    }

    @Override
    public List<String> getAllCryptos(int portfolioId) {
        return null;
    }

    @Override
    public List<Orders> getAllOrders() {
        return null;
    }

    @Override
    public List<Orders> getAllOrdersByPortfolioId(int portfolioId) {
        return null;
    }

    @Override
    public Orders purchaseCrypto(Orders order) {
        return null;
    }

    @Override
    public Orders sellCrypto(Orders order) {
        return null;
    }

    @Override
    public Users deleteAccount(Users user) {
        return null;
    }
}
