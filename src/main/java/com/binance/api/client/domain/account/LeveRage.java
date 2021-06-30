package com.binance.api.client.domain.account;

public class LeveRage {
    private Integer leverage;
    private String maxNotionalValue;
    private String symbol;

    public Integer getLeverage() {
        return leverage;
    }

    public void setLeverage(Integer leverage) {
        this.leverage = leverage;
    }

    public String getMaxNotionalValue() {
        return maxNotionalValue;
    }

    public void setMaxNotionalValue(String maxNotionalValue) {
        this.maxNotionalValue = maxNotionalValue;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
