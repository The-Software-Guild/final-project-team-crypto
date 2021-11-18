package com.mthree.cryptoinvesting.model;

import java.util.Objects;

public class Portfolio {

    private int portfolioId;
    private int userId;

    private float BTC;
    private float ETH;
    private float BNB;
    private float ADA;
    private float SOL;
    private float DOGE;

    public int getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(int portfolioId) {
        this.portfolioId = portfolioId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getBTC() {
        return BTC;
    }

    public void setBTC(float BTC) {
        this.BTC = BTC;
    }

    public float getETH() {
        return ETH;
    }

    public void setETH(float ETH) {
        this.ETH = ETH;
    }

    public float getBNB() {
        return BNB;
    }

    public void setBNB(float BNB) {
        this.BNB = BNB;
    }

    public float getADA() {
        return ADA;
    }

    public void setADA(float ADA) {
        this.ADA = ADA;
    }

    public float getSOL() {
        return SOL;
    }

    public void setSOL(float SOL) {
        this.SOL = SOL;
    }

    public float getDOGE() {
        return DOGE;
    }

    public void setDOGE(float DOGE) {
        this.DOGE = DOGE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return getPortfolioId() == portfolio.getPortfolioId() && getUserId() == portfolio.getUserId() && Float.compare(portfolio.getBTC(), getBTC()) == 0 && Float.compare(portfolio.getETH(), getETH()) == 0 && Float.compare(portfolio.getBNB(), getBNB()) == 0 && Float.compare(portfolio.getADA(), getADA()) == 0 && Float.compare(portfolio.getSOL(), getSOL()) == 0 && Float.compare(portfolio.getDOGE(), getDOGE()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPortfolioId(), getUserId(), getBTC(), getETH(), getBNB(), getADA(), getSOL(), getDOGE());
    }
}
