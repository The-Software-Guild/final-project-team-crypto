package com.mthree.cryptoinvesting.service;

import com.mthree.cryptoinvesting.data.OrderDao;
import com.mthree.cryptoinvesting.data.PortfolioDao;
import com.mthree.cryptoinvesting.data.PriceDao;
import com.mthree.cryptoinvesting.data.UserDao;
import com.mthree.cryptoinvesting.model.Orders;
import com.mthree.cryptoinvesting.model.Price;
import com.mthree.cryptoinvesting.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kristi & Chelsey
 * @version 11/22/2021
 */

@Service
public class CryptoInvestingServiceLayerDatabaseImpl implements CryptoInvestingServiceLayer{

    @Autowired
    OrderDao orderDao;

    @Autowired
    PortfolioDao portfolioDao;

    @Autowired
    UserDao userDao;

    @Autowired
    PriceDao priceDao;

    @Override
    public int newUser(Users user) {
        userDao.addUser(user);
        portfolioDao.addPortfolio(user);
        return user.getUserId();
    }

    @Override
    public List<String> getAllCryptos(int userId) {
        return portfolioDao.getAllCryptos(userId);
    }

    @Override
    public List<Orders> getAllOrders() {
        return orderDao.getAllOrders();
    }

    @Override
    public List<Orders> getAllOrdersByPortfolioId(int portfolioId) {
        return orderDao.getAllOrdersByPortfolioId(portfolioId);
    }

    @Override
    public Orders purchaseCrypto(Orders order) {
        Orders purchased = orderDao.addOrder(order);
        portfolioDao.updatePortfolio(order);
        return purchased;
    }

    @Override
    public Orders sellCrypto(Orders order) {
        Orders sold = orderDao.removeOrder(order);
        portfolioDao.sellCrypto(order);
        return sold;
    }

    @Override
    public boolean deleteAccount(Users user) {
        return userDao.deleteUser(user);
    }

    @Override
    public boolean updatePrice(Price price) {
        return priceDao.updatePrice(price);
    }

    @Override
    public List<Price> getAllPrices() {
        return priceDao.getAllPrices();
    }

    @Override
    public Price getPriceByTicker(String ticker) {
        return priceDao.getPriceByTicker(ticker);
    }

    @Override
    public Users getUserByName(Users user) {
        Users login = userDao.getUserByName(user.getUsername());
        if (login.getPassword().equals(user.getPassword()) || login.getUsername().equals("Error")){
            return login;
        }else{
            return new Users("Error", "Wrong Password");
        }
    }


}
