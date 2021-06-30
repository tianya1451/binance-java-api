package com.binance.api.client.domain.account;

public class SwapAsset {
    private String asset;//资产
    private String walletBalance;//余额
    private String unrealizedProfit;// 未实现盈亏
    private String marginBalance;// 保证金余额
    private String maintMargin;// 维持保证金
    private String initialMargin;// 当前所需起始保证金
    private String positionInitialMargin;// 持仓所需起始保证金(基于最新标记价格)
    private String openOrderInitialMargin; // 当前挂单所需起始保证金(基于最新标记价格)
    private String crossWalletBalance;//全仓账户余额
    private String crossUnPnl;// 全仓持仓未实现盈亏
    private String availableBalance;// 可用余额
    private String maxWithdrawAmount;// 最大可转出余额
    private Boolean marginAvailable;// 否可用作联合保证金

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(String walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getUnrealizedProfit() {
        return unrealizedProfit;
    }

    public void setUnrealizedProfit(String unrealizedProfit) {
        this.unrealizedProfit = unrealizedProfit;
    }

    public String getMarginBalance() {
        return marginBalance;
    }

    public void setMarginBalance(String marginBalance) {
        this.marginBalance = marginBalance;
    }

    public String getMaintMargin() {
        return maintMargin;
    }

    public void setMaintMargin(String maintMargin) {
        this.maintMargin = maintMargin;
    }

    public String getInitialMargin() {
        return initialMargin;
    }

    public void setInitialMargin(String initialMargin) {
        this.initialMargin = initialMargin;
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

    public String getCrossWalletBalance() {
        return crossWalletBalance;
    }

    public void setCrossWalletBalance(String crossWalletBalance) {
        this.crossWalletBalance = crossWalletBalance;
    }

    public String getCrossUnPnl() {
        return crossUnPnl;
    }

    public void setCrossUnPnl(String crossUnPnl) {
        this.crossUnPnl = crossUnPnl;
    }

    public String getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(String availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getMaxWithdrawAmount() {
        return maxWithdrawAmount;
    }

    public void setMaxWithdrawAmount(String maxWithdrawAmount) {
        this.maxWithdrawAmount = maxWithdrawAmount;
    }

    public Boolean getMarginAvailable() {
        return marginAvailable;
    }

    public void setMarginAvailable(Boolean marginAvailable) {
        this.marginAvailable = marginAvailable;
    }
}
