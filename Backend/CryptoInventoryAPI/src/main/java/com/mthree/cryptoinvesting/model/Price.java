package com.mthree.cryptoinvesting.model;

import java.util.Objects;

public class Price {
    private String ticker;
    private float price;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticket) {
        this.ticker = ticket;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price1 = (Price) o;
        return Float.compare(price1.getPrice(), getPrice()) == 0 && Objects.equals(getTicker(), price1.getTicker());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTicker(), getPrice());
    }
}
