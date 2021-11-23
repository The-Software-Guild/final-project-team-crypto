package com.mthree.cryptoinvesting.model;

import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * @author Kristi
 * @author Chelsey
 * @version 11/18/2021
 */

public class Orders {

    private int orderId;
    private int portfolioId;

    private String cryptoName;

    private float price;
    private float amount;

    private LocalDateTime datePurchased;
    private LocalDateTime dateSold;

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
        return datePurchased.truncatedTo(ChronoUnit.SECONDS);
    }

    public LocalDateTime getDateSold() {
        if (dateSold == null)  {
            return null;
        }
        return dateSold.truncatedTo(ChronoUnit.SECONDS); }

    public void setDatePurchased(LocalDateTime datePurchased) {
        this.datePurchased = datePurchased.truncatedTo(ChronoUnit.SECONDS);
    }

    public void setDateSold(LocalDateTime dateSold) {
        this.dateSold = dateSold.truncatedTo(ChronoUnit.SECONDS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return getOrderId() == orders.getOrderId() && getPortfolioId() == orders.getPortfolioId() && Float.compare(orders.getPrice(), getPrice()) == 0 && Float.compare(orders.getAmount(), getAmount()) == 0 && Objects.equals(getCryptoName(), orders.getCryptoName()) && Objects.equals(getDatePurchased(), orders.getDatePurchased()) && Objects.equals(getDateSold(), orders.getDateSold());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getPortfolioId(), getCryptoName(), getPrice(), getAmount(), getDatePurchased(), getDateSold());
    }
}