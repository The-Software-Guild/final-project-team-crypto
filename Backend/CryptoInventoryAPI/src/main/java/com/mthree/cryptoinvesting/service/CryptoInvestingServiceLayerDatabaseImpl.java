package com.mthree.cryptoinvesting.service;

import com.mthree.cryptoinvesting.data.OrderDao;
import com.mthree.cryptoinvesting.data.PortfolioDao;
import com.mthree.cryptoinvesting.data.UserDao;
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
}
