package com.mthree.cryptoinvesting.service;


import java.util.List;

public interface CryptoInvestingServiceLayer {

    int newUser();

    List<String> getAllCryptos(int portfolioId);

}
