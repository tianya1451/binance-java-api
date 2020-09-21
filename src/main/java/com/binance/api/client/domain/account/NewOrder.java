package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.OrderSide;
import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.TimeInForce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * A trade order to enter or exit a position.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewOrder {

  /**
   * Symbol to place the order on.
   */
  private String symbol;

  /**
   * Buy/Sell order side.
   */
  private OrderSide side;

  /**
   * Type of order.
   */
  private OrderType type;


  /**
   * Quantity.
   */
  private String quantity;
  /**
   * Quantity.
   */
  private String quoteOrderQty;

  /**
   * Price.
   */
  private String price;

  /**
   * A unique id for the order. Automatically generated if not sent.
   */
  private String newClientOrderId;

  /**
   * Used with stop orders.
   */
  private String stopPrice;

  /**
   * Used with iceberg orders.
   */
  private String icebergQty;
  /**
   * Used with iceberg orders.
   */
  private String timeInForce;

  /**
   * Set the response JSON. ACK, RESULT, or FULL; default: RESULT.
   */
  private NewOrderResponseType newOrderRespType;

  /**
   * Receiving window.
   */
  private Long recvWindow;

  /**
   * Order timestamp.
   */
  private long timestamp;

  /**
   * Creates a new order with all required parameters.
   */
  public NewOrder(String symbol, OrderSide side, OrderType type,  String quoteOrderQty) {
    this.symbol = symbol;
    this.side = side;
    this.type = type;
    this.quoteOrderQty = quoteOrderQty;
    this.newOrderRespType = NewOrderResponseType.RESULT;
    this.timestamp = System.currentTimeMillis();
    this.recvWindow = BinanceApiConstants.DEFAULT_RECEIVING_WINDOW;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public void setSide(OrderSide side) {
    this.side = side;
  }

  public void setType(OrderType type) {
    this.type = type;
  }

  public String getQuantity() {
    return quantity;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public void setQuoteOrderQty(String quoteOrderQty) {
    this.quoteOrderQty = quoteOrderQty;
  }

  public void setNewClientOrderId(String newClientOrderId) {
    this.newClientOrderId = newClientOrderId;
  }

  public void setStopPrice(String stopPrice) {
    this.stopPrice = stopPrice;
  }

  public void setIcebergQty(String icebergQty) {
    this.icebergQty = icebergQty;
  }

  public void setNewOrderRespType(NewOrderResponseType newOrderRespType) {
    this.newOrderRespType = newOrderRespType;
  }

  public void setRecvWindow(Long recvWindow) {
    this.recvWindow = recvWindow;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public String getSymbol() {
    return symbol;
  }

  public NewOrder symbol(String symbol) {
    this.symbol = symbol;
    return this;
  }

  public OrderSide getSide() {
    return side;
  }

  public NewOrder side(OrderSide side) {
    this.side = side;
    return this;
  }

  public OrderType getType() {
    return type;
  }

  public NewOrder type(OrderType type) {
    this.type = type;
    return this;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public String getTimeInForce() {
    return timeInForce;
  }

  public void setTimeInForce(String timeInForce) {
    this.timeInForce = timeInForce;
  }

  public String getQuoteOrderQty() {
    return quoteOrderQty;
  }

  public NewOrder quoteOrderQty(String quoteOrderQty) {
    this.quoteOrderQty = quoteOrderQty;
    return this;
  }

  public String getPrice() {
    return price;
  }

  public NewOrder price(String price) {
    this.price = price;
    return this;
  }

  public String getNewClientOrderId() {
    return newClientOrderId;
  }

  public NewOrder newClientOrderId(String newClientOrderId) {
    this.newClientOrderId = newClientOrderId;
    return this;
  }

  public String getStopPrice() {
    return stopPrice;
  }

  public NewOrder stopPrice(String stopPrice) {
    this.stopPrice = stopPrice;
    return this;
  }

  public String getIcebergQty() {
    return icebergQty;
  }

  public NewOrder icebergQty(String icebergQty) {
    this.icebergQty = icebergQty;
    return this;
  }

  public NewOrderResponseType getNewOrderRespType() {
    return newOrderRespType;
  }

  public NewOrder newOrderRespType(NewOrderResponseType newOrderRespType) {
    this.newOrderRespType = newOrderRespType;
    return this;
  }

  public Long getRecvWindow() {
    return recvWindow;
  }

  public NewOrder recvWindow(Long recvWindow) {
    this.recvWindow = recvWindow;
    return this;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public NewOrder timestamp(long timestamp) {
    this.timestamp = timestamp;
    return this;
  }


  @Override
  public String toString() {
    return new ToStringBuilder(this, BinanceApiConstants.TO_STRING_BUILDER_STYLE)
        .append("symbol", symbol)
        .append("side", side)
        .append("type", type)
        .append("quoteOrderQty", quoteOrderQty)
        .append("price", price)
        .append("newClientOrderId", newClientOrderId)
        .append("stopPrice", stopPrice)
        .append("icebergQty", icebergQty)
        .append("newOrderRespType", newOrderRespType)
        .append("recvWindow", recvWindow)
        .append("timestamp", timestamp)
        .toString();
  }
}
