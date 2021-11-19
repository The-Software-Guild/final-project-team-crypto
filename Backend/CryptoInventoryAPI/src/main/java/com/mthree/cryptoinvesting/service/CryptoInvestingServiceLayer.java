package com.mthree.cryptoinvesting.service;


import com.mthree.cryptoinvesting.model.Orders;
import com.mthree.cryptoinvesting.model.Users;

import java.util.List;

/**
 * @author Kristi
 * @version 11/19/2021
 */

public interface CryptoInvestingServiceLayer {

    int newUser();

    List<String> getAllCryptos(int portfolioId);

    List<Orders> getAllOrders();

    List<Orders> getAllOrdersByPortfolioId(int portfolioId);

    Orders purchaseCrypto(Orders order);

    Orders sellCrypto(Orders order);

    Users deleteAccount(Users user);

}
