package com.binance.api.client.domain.account;

public class SwapPosition {
    private String symbol;// 交易对
    private String initialMargin;// 当前所需起始保证金(基于最新标记价格)
    private String maintMargin;//维持保证金
    private String unrealizedProfit;// 持仓未实现盈亏
    private String positionInitialMargin;// 持仓所需起始保证金(基于最新标记价格)
    private String openOrderInitialMargin;// 当前挂单所需起始保证金(基于最新标记价格)
    private String leverage; // 杠杆倍率
    private Boolean isolated;// 是否是逐仓模式
    private String entryPrice;// 持仓成本价
    private String maxNotional;// 当前杠杆下用户可用的最大名义价值
    private String positionSide;// 持仓方向
    private String positionAmt;// 持仓数量

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getInitialMargin() {
        return initialMargin;
    }

    public void setInitialMargin(String initialMargin) {
        this.initialMargin = initialMargin;
    }

    public String getMaintMargin() {
        return maintMargin;
    }

    public void setMaintMargin(String maintMargin) {
        this.maintMargin = maintMargin;
    }

    public String getUnrealizedProfit() {
        return unrealizedProfit;
    }

    public void setUnrealizedProfit(String unrealizedProfit) {
        this.unrealizedProfit = unrealizedProfit;
    }

    public String getPositionInitialMargin() {
        return positionInitialMargin;
    }

    public void setPositionInitialMargin(String positionInitialMargin) {
        this.positionInitialMargin = positionInitialMargin;
    }

    public String getOpenOrderInitialMargin() {
        return openOrderInitialMargin;
    }

    public void setOpenOrderInitialMargin(String openOrderInitialMargin) {
        this.openOrderInitialMargin = openOrderInitialMargin;
    }

    public String getLeverage() {
        return leverage;
    }

    public void setLeverage(String leverage) {
        this.leverage = leverage;
    }

    public Boolean getIsolated() {
        return isolated;
    }

    public void setIsolated(Boolean isolated) {
        this.isolated = isolated;
    }

    public String getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(String entryPrice) {
        this.entryPrice = entryPrice;
    }

    public String getMaxNotional() {
        return maxNotional;
    }

    public void setMaxNotional(String maxNotional) {
        this.maxNotional = maxNotional;
    }

    public String getPositionSide() {
        return positionSide;
    }

    public void setPositionSide(String positionSide) {
        this.positionSide = positionSide;
    }

    public String getPositionAmt() {
        return positionAmt;
    }

    public void setPositionAmt(String positionAmt) {
        this.positionAmt = positionAmt;
    }
}
