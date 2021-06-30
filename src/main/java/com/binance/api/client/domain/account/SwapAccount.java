package com.binance.api.client.domain.account;

import java.util.Iterator;
import java.util.List;

public class SwapAccount {
    private Integer feeTier;// 手续费等级
    private Boolean canTrade;// 是否可以交易
    private Boolean canDeposit;// 是否可以入金
    private Boolean canWithdraw;// 是否可以出金
    private Long updateTime;
    private String totalInitialMargin; // 但前所需起始保证金总额(存在逐仓请忽略), 仅计算usdt资产
    private String totalMaintMargin;// 维持保证金总额, 仅计算usdt资产
    private String totalWalletBalance;// 账户总余额, 仅计算usdt资产
    private String totalUnrealizedProfit;// 持仓未实现盈亏总额, 仅计算usdt资产
    private String totalMarginBalance;// 保证金总余额, 仅计算usdt资产
    private String totalPositionInitialMargin;// 持仓所需起始保证金(基于最新标记价格), 仅计算usdt资产
    private String totalOpenOrderInitialMargin;// 当前挂单所需起始保证金(基于最新标记价格), 仅计算usdt资产
    private String totalCrossWalletBalance;// 全仓账户余额, 仅计算usdt资产
    private String totalCrossUnPnl;// 全仓持仓未实现盈亏总额, 仅计算usdt资产
    private String availableBalance;// 可用余额, 仅计算usdt资产
    private String maxWithdrawAmount;// 最大可转出余额, 仅计算usdt资产
    private List<SwapAsset> assets;
    private List<SwapPosition> positions;

    public Integer getFeeTier() {
        return feeTier;
    }

    public void setFeeTier(Integer feeTier) {
        this.feeTier = feeTier;
    }

    public Boolean getCanTrade() {
        return canTrade;
    }

    public void setCanTrade(Boolean canTrade) {
        this.canTrade = canTrade;
    }

    public Boolean getCanDeposit() {
        return canDeposit;
    }

    public void setCanDeposit(Boolean canDeposit) {
        this.canDeposit = canDeposit;
    }

    public Boolean getCanWithdraw() {
        return canWithdraw;
    }

    public void setCanWithdraw(Boolean canWithdraw) {
        this.canWithdraw = canWithdraw;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getTotalInitialMargin() {
        return totalInitialMargin;
    }

    public void setTotalInitialMargin(String totalInitialMargin) {
        this.totalInitialMargin = totalInitialMargin;
    }

    public String getTotalMaintMargin() {
        return totalMaintMargin;
    }

    public void setTotalMaintMargin(String totalMaintMargin) {
        this.totalMaintMargin = totalMaintMargin;
    }

    public String getTotalWalletBalance() {
        return totalWalletBalance;
    }

    public void setTotalWalletBalance(String totalWalletBalance) {
        this.totalWalletBalance = totalWalletBalance;
    }

    public String getTotalUnrealizedProfit() {
        return totalUnrealizedProfit;
    }

    public void setTotalUnrealizedProfit(String totalUnrealizedProfit) {
        this.totalUnrealizedProfit = totalUnrealizedProfit;
    }

    public String getTotalMarginBalance() {
        return totalMarginBalance;
    }

    public void setTotalMarginBalance(String totalMarginBalance) {
        this.totalMarginBalance = totalMarginBalance;
    }

    public String getTotalPositionInitialMargin() {
        return totalPositionInitialMargin;
    }

    public void setTotalPositionInitialMargin(String totalPositionInitialMargin) {
        this.totalPositionInitialMargin = totalPositionInitialMargin;
    }

    public String getTotalOpenOrderInitialMargin() {
        return totalOpenOrderInitialMargin;
    }

    public void setTotalOpenOrderInitialMargin(String totalOpenOrderInitialMargin) {
        this.totalOpenOrderInitialMargin = totalOpenOrderInitialMargin;
    }

    public String getTotalCrossWalletBalance() {
        return totalCrossWalletBalance;
    }

    public void setTotalCrossWalletBalance(String totalCrossWalletBalance) {
        this.totalCrossWalletBalance = totalCrossWalletBalance;
    }

    public String getTotalCrossUnPnl() {
        return totalCrossUnPnl;
    }

    public void setTotalCrossUnPnl(String totalCrossUnPnl) {
        this.totalCrossUnPnl = totalCrossUnPnl;
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

    public List<SwapAsset> getAssets() {
        return assets;
    }

    public void setAssets(List<SwapAsset> assets) {
        this.assets = assets;
    }

    public List<SwapPosition> getPositions() {
        return positions;
    }

    public void setPositions(List<SwapPosition> positions) {
        this.positions = positions;
    }

    public SwapAsset getAssetBalance(String symbol) {
        Iterator var2 = this.assets.iterator();

        SwapAsset assetBalance;
        do {
            if (!var2.hasNext()) {
                SwapAsset emptyBalance = new SwapAsset();
                emptyBalance.setAsset(symbol);
                emptyBalance.setAvailableBalance("0");
                emptyBalance.setMaxWithdrawAmount("0");
                emptyBalance.setWalletBalance("0");
                return emptyBalance;
            }

            assetBalance = (SwapAsset)var2.next();
        } while(!symbol.equals(assetBalance.getAsset()));

        return assetBalance;
    }
}
