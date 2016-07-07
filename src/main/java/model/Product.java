package main.java.model;

import main.java.controller.dao.oracle.ParseHandler;
import java.util.Date;

public class Product {
    private int id;
    private String sellerLogin;
    private String name;
    private String description;
    private double price;
    private double gap;
    private int hours;
    private Date startBiddingDate;
    private boolean buyNow;

    public Product(){}

    public Product(int id, String sellerLogin, String name, String description, double price, double gap,
                   int hours, Date startBiddingDate, boolean buyNow) {
        this.id = id;
        this.sellerLogin = sellerLogin;
        this.name = name;
        this.description = description;
        this.price = price;
        this.gap = gap;
        this.hours = hours;
        this.startBiddingDate = startBiddingDate;
        this.buyNow = buyNow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSellerLogin() {
        return sellerLogin;
    }

    public void setSellerLogin(String sellerLogin) {
        this.sellerLogin = sellerLogin;
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

    @Override
    public String toString() {
        return id + " | " + sellerLogin + " | " + name + " | " + description + " | " + price +
                " | " + gap + " | " + hours + " | " + ParseHandler.dateToString(startBiddingDate) + " | " + buyNow;
    }

    @Override
    public int hashCode() {
        return id * sellerLogin.length() * name.length() * description.length();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (this == obj){
            return true;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Product product = (Product)obj;
        if (id != product.getId()){
            return false;
        }
        if (!sellerLogin.equals(product.getSellerLogin())){
            return false;
        }
        if (!name.equals(product.getName())){
            return false;
        }
        if (!description.equals(product.getDescription())){
            return false;
        }
        if (price != product.getPrice()){
            return false;
        }
        if (gap != product.getGap()){
            return false;
        }
        if (hours != product.getHours()){
            return false;
        }
        if (!startBiddingDate.equals(product.getStartBiddingDate())){
            return false;
        }
        if (buyNow != product.isBuyNow()){
            return false;
        }
        return true;
    }
}
