package model;

/**
 * Created by Andrei_Zanozin on 6/24/2016.
 */
public class Bid {
    private int id;
    private String userLogin;
    private int productId;
    private double bid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return id + " | " + userLogin + " | " + productId + " | " + bid;
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
        Bid bid = (Bid)obj;
        if (id != bid.getId()){
            return false;
        }
        if (!userLogin.equals(bid.getUserLogin())){
            return false;
        }
        if (productId != bid.getProductId()){
            return false;
        }
        if (this.bid != bid.getBid()){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return id * userLogin.length() * productId;
    }
}
