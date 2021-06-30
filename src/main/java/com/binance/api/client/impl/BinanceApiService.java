package com.binance.api.client.impl;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.OrderSide;
import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.domain.account.request.CancelOrderResponse;
import com.binance.api.client.domain.enums.swap.NewOrderRespType;
import com.binance.api.client.domain.enums.swap.PositionSide;
import com.binance.api.client.domain.enums.swap.WorkingType;
import com.binance.api.client.domain.event.ListenKey;
import com.binance.api.client.domain.general.Asset;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.general.ServerTime;
import com.binance.api.client.domain.market.AggTrade;
import com.binance.api.client.domain.market.BookTicker;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;

import java.lang.ref.Reference;
import java.util.List;

/**
 * Binance's REST API URL mappings and endpoint security configuration.
 */
public interface BinanceApiService {

  // General endpoints

  @GET("/api/v1/ping")
  Call<Void> ping();

  @GET("/api/v1/time")
  Call<ServerTime> getServerTime();

  @GET("/api/v1/exchangeInfo")
  Call<ExchangeInfo> getExchangeInfo();

  @GET
  Call<List<Asset>> getAllAssets(@Url String url);

  // Market data endpoints

  @GET("/api/v1/depth")
  Call<OrderBook> getOrderBook(@Query("symbol") String symbol, @Query("limit") Integer limit);

  @GET("/api/v1/trades")
  Call<List<TradeHistoryItem>> getTrades(@Query("symbol") String symbol, @Query("limit") Integer limit);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
  @GET("/api/v1/historicalTrades")
  Call<List<TradeHistoryItem>> getHistoricalTrades(@Query("symbol") String symbol, @Query("limit") Integer limit, @Query("fromId") Long fromId);

  @GET("/api/v1/aggTrades")
  Call<List<AggTrade>> getAggTrades(@Query("symbol") String symbol, @Query("fromId") String fromId, @Query("limit") Integer limit,
                                    @Query("startTime") Long startTime, @Query("endTime") Long endTime);

  @GET("/api/v1/klines")
  Call<List<Candlestick>> getCandlestickBars(@Query("symbol") String symbol, @Query("interval") String interval, @Query("limit") Integer limit,
                                       @Query("startTime") Long startTime, @Query("endTime") Long endTime);

  @GET("/api/v1/ticker/24hr")
  Call<TickerStatistics> get24HrPriceStatistics(@Query("symbol") String symbol);

  @GET("/api/v1/ticker/24hr")
  Call<List<TickerStatistics>> getAll24HrPriceStatistics();

  @GET("/api/v1/ticker/allPrices")
  Call<List<TickerPrice>> getLatestPrices();

  @GET("/api/v3/ticker/price")
  Call<TickerPrice> getLatestPrice(@Query("symbol") String symbol);

  @GET("/api/v1/ticker/allBookTickers")
  Call<List<BookTicker>> getBookTickers();

  // Account endpoints

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @POST("/api/v3/order")
  Call<NewOrderResponse> newOrderBuy(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                                  @Query("quoteOrderQty") String quoteOrderQty, @Query("price") String price,
                                  @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                                  @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                  @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);
  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @POST("/api/v3/order")
  Call<NewOrderResponse> newOrderSell(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                                  @Query("quantity") String quantity, @Query("price") String price,
                                  @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                                  @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                  @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);
  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @POST("/api/v3/order")
  Call<NewOrderResponse> newOrderBuyLimit(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                                  @Query("quantity") String quantity, @Query("price") String price,
                                  @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                                  @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                  @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp, @Query("timeInForce") String timeInForce);
  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @POST("/api/v3/order")
  Call<NewOrderResponse> newOrderSellLimit(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                                  @Query("quantity") String quantity, @Query("price") String price,
                                  @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                                  @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                                  @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp, @Query("timeInForce") String timeInForce);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @POST("/api/v3/order/test")
  Call<Void> newOrderTest(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
                          @Query("quoteOrderQty") String quoteOrderQty, @Query("price") String price,
                          @Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
                          @Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
                          @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @GET("/api/v3/order")
  Call<Order> getOrderStatus(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                    @Query("origClientOrderId") String origClientOrderId, @Query("recvWindow") Long recvWindow,
                                    @Query("timestamp") Long timestamp);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @DELETE("/api/v3/order")
  Call<CancelOrderResponse> cancelOrder(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                        @Query("origClientOrderId") String origClientOrderId, @Query("newClientOrderId") String newClientOrderId,
                                        @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @GET("/api/v3/openOrders")
  Call<List<Order>> getOpenOrders(@Query("symbol") String symbol, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @GET("/api/v3/allOrders")
  Call<List<Order>> getAllOrders(@Query("symbol") String symbol, @Query("orderId") Long orderId,
                                 @Query("limit") Integer limit, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @GET("/api/v3/account")
  Call<Account> getAccount(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @GET("/api/v3/myTrades")
  Call<List<Trade>> getMyTrades(@Query("symbol") String symbol, @Query("limit") Integer limit, @Query("fromId") Long fromId,
                                @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @POST("/wapi/v3/withdraw.html")
  Call<WithdrawResult> withdraw(@Query("asset") String asset, @Query("address") String address, @Query("amount") String amount, @Query("name") String name, @Query("addressTag") String addressTag,
                                @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @GET("/wapi/v3/depositHistory.html")
  Call<DepositHistory> getDepositHistory(@Query("asset") String asset, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @GET("/wapi/v3/withdrawHistory.html")
  Call<WithdrawHistory> getWithdrawHistory(@Query("asset") String asset, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
  @GET("/wapi/v3/depositAddress.html")
  Call<DepositAddress> getDepositAddress(@Query("asset") String asset, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);

  // User stream endpoints

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
  @POST("/api/v1/userDataStream")
  Call<ListenKey> startUserDataStream();

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
  @PUT("/api/v1/userDataStream")
  Call<Void> keepAliveUserDataStream(@Query("listenKey") String listenKey);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
  @DELETE("/api/v1/userDataStream")
  Call<Void> closeAliveUserDataStream(@Query("listenKey") String listenKey);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
  @GET("/fapi/v1/order")
  Call<SwapNewOrder> newSwapOrderBuy(@Query("symbol")String symbol, @Query("side")OrderSide side, @Query("positionSide")PositionSide positionSide,
                                     @Query("orderType")com.binance.api.client.domain.enums.swap.OrderType orderType,
                                     @Query("timeInForce")com.binance.api.client.domain.enums.swap.TimeInForce timeInForce, @Query("quantity")String quantity,
                                     @Query("price")String price, @Query("reduceOnly")String reduceOnly, @Query("newClientOrderId")String newClientOrderId,
                                     @Query("stopPrice")String stopPrice,
                                     @Query("workingType")WorkingType workingType, @Query("newOrderRespType")NewOrderRespType newOrderRespType,
                                     @Query("timestamp") Long timestamp);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
  @POST("/fapi/v1/order")
  Call<SwapNewOrder> getOrder(@Query("symbol")String symbol, @Query("orderId")String orderId, @Query("origClientOrderId")String origClientOrderId, @Query("timestamp") Long timestamp);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
  @POST("/fapi/v1/leverage")
  Call<LeveRage> setLeveRage(@Query("symbol")String symbol, @Query("leverage")Integer leverage, @Query("timestamp")long timestamp);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
  @GET("/fapi/v2/account")
  Call<SwapAccount> getSwapAccount(@Query("timestamp") Long timestamp);

  @Headers(BinanceApiConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
  @POST("/sapi/v1/futures/transfer")
  Call<AccountTransfer> transfer( @Query("asset")String asset, @Query("amount")String amount, @Query("type")String type, @Query("timestamp") Long timestamp);
}
