package com.mthree.cryptoinvesting.controllers;

import com.mthree.cryptoinvesting.service.CryptoInvestingServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public int createUser(){
        return service.newUser();
    }

    @GetMapping("/cryptos/{portfolioId}")
    public List<String> getAllCryptos(@PathVariable("portfolioId") int portfolioId) {
        return service.getAllCryptos(portfolioId);
    }

}
