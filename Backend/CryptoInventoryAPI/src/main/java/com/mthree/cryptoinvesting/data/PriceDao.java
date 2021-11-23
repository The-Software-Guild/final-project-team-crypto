package com.mthree.cryptoinvesting.data;

import com.mthree.cryptoinvesting.model.Price;
import com.mthree.cryptoinvesting.model.Users;

import java.util.List;

public interface PriceDao {

    boolean updatePrice(Price price);

    List<Price> getAllPrices();

    Price getPriceByTicker(String ticker);


}