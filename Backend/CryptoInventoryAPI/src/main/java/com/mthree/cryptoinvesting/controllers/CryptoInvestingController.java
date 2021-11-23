package com.mthree.cryptoinvesting.controllers;

import com.mthree.cryptoinvesting.model.Orders;
import com.mthree.cryptoinvesting.model.Price;
import com.mthree.cryptoinvesting.model.Users;
import com.mthree.cryptoinvesting.service.CryptoInvestingServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kristi
 * @version 11/19/2021
 */


@RestController
@RequestMapping("/api/cryptoinventory")
public class CryptoInvestingController {

    @Autowired
    CryptoInvestingServiceLayer service;

    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public int createUser(@RequestBody Users user){
        return service.newUser(user);
    }

    @GetMapping("/cryptos/{portfolioId}")
    public List<String> getAllCryptos(@PathVariable("portfolioId") int portfolioId) {
        return service.getAllCryptos(portfolioId);
    }

    @GetMapping("/order")
    public List<Orders> getAllOrders() {
        return service.getAllOrders();
    }


    @GetMapping("/prices")
    public List<Price> getAllPrices() {
        return service.getAllPrices();
    }

    @GetMapping("/price/{ticker}")
    public Price getPrice(@PathVariable("ticker") String ticker){
        return service.getPriceByTicker(ticker.toUpperCase());
    }

    @GetMapping("/order/{portfolioId}")
    public List<Orders> getOrdersByPortfolio(@PathVariable("portfolioId") int portfolioId) {
        return service.getAllOrdersByPortfolioId(portfolioId);
    }

    @PostMapping("/buy")
    public Orders purchaseCrypto(@RequestBody Orders order) {
        return service.purchaseCrypto(order);
    }

    @PostMapping("/sell")
    public Orders sellCrypto(@RequestBody Orders order) {
        return service.sellCrypto(order);
    }

    @PostMapping("/delete")
    public boolean deleteAccount(@RequestBody Users user) {
        return service.deleteAccount(user);
    }

    @PutMapping("/updatePrice")
    public boolean update(@RequestBody Price price) {
        return service.updatePrice(price);
    }



}
