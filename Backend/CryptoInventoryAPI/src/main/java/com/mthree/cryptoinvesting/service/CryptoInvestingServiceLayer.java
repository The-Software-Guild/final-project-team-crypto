package com.mthree.cryptoinvesting.service;


import java.util.List;

/**
 * @author Kristi
 * @version 11/19/2021
 */

public interface CryptoInvestingServiceLayer {

    int newUser();

    List<String> getAllCryptos(int portfolioId);

}
