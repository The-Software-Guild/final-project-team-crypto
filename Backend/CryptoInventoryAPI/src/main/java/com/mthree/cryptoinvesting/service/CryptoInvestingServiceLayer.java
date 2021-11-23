package com.mthree.cryptoinvesting.service;


import com.mthree.cryptoinvesting.model.Orders;
import com.mthree.cryptoinvesting.model.Price;
import com.mthree.cryptoinvesting.model.Users;

import java.util.List;

/**
 * @author Kristi
 * @version 11/19/2021
 */

public interface CryptoInvestingServiceLayer {

    /**
     * Creates a new user in the database.
     * @return The id of the new user.
     */
    int newUser(Users user);

    /**
     * Returns a list of all cryptos that exist for a particular user.
     * @param userId The portfolio id associated with a specific user.
     * @return
     */
    List<String> getAllCryptos(int userId);

    /**
     * Retuns all orders that exist within the database.
     * @return A list of all orders in the database.
     */
    List<Orders> getAllOrders();

    /**
     * A list of all orders in a particular portfolio in the database.
     * @param portfolioId The portfolio to look for orders from.
     * @return A list of orders associated with a portfolio.
     */
    List<Orders> getAllOrdersByPortfolioId(int portfolioId);

    /**
     * Returns the crypto order that a user is buying. Updates
     * the portfolio file so that all cryptos are accounted for.
     * @param order The order the user is purchasing.
     * @return The order that was just placed.
     */
    Orders purchaseCrypto(Orders order);

    /**
     * Returns the crypto that a user is selling. Updates the
     * portfolio file so that a user's crypto info is accurate.
     * @param order The crypto that was just sold.
     * @return The order that was just sold.
     */
    Orders sellCrypto(Orders order);

    /**
     * Deletes the user's account and all associated information.
     * @param user The user that will be deleted.
     * @return The deleted user information.
     */
    boolean deleteAccount(Users user);

    // price methods
    boolean updatePrice(Price price);

    List<Price> getAllPrices();

    Price getPriceByTicker(String ticker);

}
