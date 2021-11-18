package com.mthree.cryptoinvesting.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {

    private int orderId;
    private int portfolioId;

    private String cName;

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

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
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
        Order order = (Order) o;
        return getOrderId() == order.getOrderId() && getPortfolioId() == order.getPortfolioId() && Float.compare(order.getPrice(), getPrice()) == 0 && Float.compare(order.getAmount(), getAmount()) == 0 && Objects.equals(getcName(), order.getcName()) && Objects.equals(getDatePurchased(), order.getDatePurchased());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getPortfolioId(), getcName(), getPrice(), getAmount(), getDatePurchased());
    }
}
