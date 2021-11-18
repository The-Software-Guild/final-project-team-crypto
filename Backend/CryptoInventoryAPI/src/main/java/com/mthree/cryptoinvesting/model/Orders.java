package com.mthree.cryptoinvesting.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Orders {

    private int orderId;
    private int portfolioId;

    private String cryptoName;

    private float price;
    private float amount;

    private LocalDateTime datePurchased;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getCryptoName() {
        return cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDateTime getDatePurchased() {
        return datePurchased;
    }

    public void setDatePurchased(LocalDateTime datePurchased) {
        this.datePurchased = datePurchased;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders order = (Orders) o;
        return getOrderId() == order.getOrderId() && getPortfolioId() == order.getPortfolioId() && Float.compare(order.getPrice(), getPrice()) == 0 && Float.compare(order.getAmount(), getAmount()) == 0 && Objects.equals(getCryptoName(), order.getCryptoName()) && Objects.equals(getDatePurchased(), order.getDatePurchased());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getPortfolioId(), getCryptoName(), getPrice(), getAmount(), getDatePurchased());
    }
}
