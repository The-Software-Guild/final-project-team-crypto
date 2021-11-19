package com.mthree.cryptoinvesting.data;

import com.mthree.cryptoinvesting.model.Orders;
import com.mthree.cryptoinvesting.model.Portfolio;

import java.util.List;

/**
 * @author Kristi
 * @version 11/19/2021
 */
public interface PortfolioDao {

    /**
     * Returns all crypto currency that exists in a specified users
     * portfolio.
     * @param userId The user whose portfolio to return.
     * @return A list of all the cryptos a person owns.
     */
    List<String> getAllCryptos(int userId);

    /**
     * Adds a new portfolio into the system including this userId it
     * is associated with.
     * @param portfolio The portfolio to add to the database.
     * @return The portfolio that was added.
     */
    Portfolio addPortfolio(Portfolio portfolio);

    /**
     * Updates the information inside the portfolio every time a
     * new cryto order is placed.
     * @param order The order that has been placed.
     * @return The portfolio with its updated crypto values.
     */
    Portfolio updatePortfolio(Orders order);

}
