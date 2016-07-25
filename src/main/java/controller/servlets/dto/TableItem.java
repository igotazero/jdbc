package main.java.controller.servlets.dto;

/**
 * Created by Andrei_Zanozin on 7/25/2016.
 */
public class TableItem {
    private String id;
    private String title;
    private String description;
    private String price;
    private String bidInc;
    private String bestOffer;
    private String bidder;
    private String stopDate;
    private String buyNow;
    private String sellerLogin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBidInc() {
        return bidInc;
    }

    public void setBidInc(String bidInc) {
        this.bidInc = bidInc;
    }

    public String getBestOffer() {
        return bestOffer;
    }

    public void setBestOffer(String bestOffer) {
        this.bestOffer = bestOffer;
    }

    public String getBidder() {
        return bidder;
    }

    public void setBidder(String bidder) {
        this.bidder = bidder;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    public String getBuyNow() {
        return buyNow;
    }

    public void setBuyNow(String buyNow) {
        this.buyNow = buyNow;
    }

    public String getSellerLogin() {
        return sellerLogin;
    }

    public void setSellerLogin(String sellerLogin) {
        this.sellerLogin = sellerLogin;
    }
}
