package model;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private double gap;
    private int hours;
    private Date startBiddingDate;
    private boolean buyNow;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getGap() {
        return gap;
    }

    public void setGap(double gap) {
        this.gap = gap;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Date getStartBiddingDate() {
        return startBiddingDate;
    }

    public void setStartBiddingDate(Date startBiddingDate) {
        this.startBiddingDate = startBiddingDate;
    }

    public boolean isBuyNow() {
        return buyNow;
    }

    public void setBuyNow(boolean buyNow) {
        this.buyNow = buyNow;
    }
}
