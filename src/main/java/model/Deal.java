package main.java.model;

import main.java.controller.dao.oracle.ParseHandler;

import java.util.Date;

/**
 * Created by Andrei_Zanozin on 7/26/2016.
 */
public class Deal {
    private int productId;
    private double bidPrice;
    private String sellerId;
    private String buyerId;
    private Date dealDate;

    public Deal(){}

    public Deal(int productId, double bidPrice, String sellerId, String buyerId, Date dealDate) {
        this.productId = productId;
        this.bidPrice = bidPrice;
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.dealDate = dealDate;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    @Override
    public String toString() {
        return productId + " | " + bidPrice + " | " + sellerId + " | " + buyerId + " | " +
                ParseHandler.dateToString(dealDate);
    }
}
