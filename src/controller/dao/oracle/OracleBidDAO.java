package controller.dao.oracle;

import controller.dao.BidDAO;
import controller.dao.ResultHandler;
import model.Bid;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/28/2016.
 */
public class OracleBidDAO implements BidDAO{
    private final String TABLE_NAME = "Bids";
    private final String ID = "ID";
    private final String USER_LOGIN = "USERLOGIN";
    private final String PRODUCT_ID = "PRODUCTID";
    private final String BID = "BID";
    private final Executor<Bid> executor = new Executor<>();
    private ResultHandler<Bid> bidResultHandler = new ResultHandler<Bid>() {
        @Override
        public List<Bid> convert(ResultSet resultSet) {
            List<Bid> list = new ArrayList<>();
            try {
                while(resultSet.next()){
                   Bid bid = new Bid();
                    bid.setId(resultSet.getInt(ID));
                    bid.setUserLogin(resultSet.getString(USER_LOGIN));
                    bid.setProductId(resultSet.getInt(PRODUCT_ID));
                    bid.setBid(resultSet.getDouble(BID));
                    list.add(bid);
                }
            }catch (SQLException e){
                e.printStackTrace();
                return null;
            }
            return list;
        }
    };

    @Override
    public int add(Bid bid) {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ").append(TABLE_NAME).append(" (")
                .append(ID).append(", ")
                .append(USER_LOGIN).append(", ")
                .append(PRODUCT_ID).append(", ")
                .append(BID).append(") VALUES (bids_seq.nextval, ?, ?, ?)");

        List<String> args = new ArrayList<>();
        args.add(bid.getUserLogin());
        args.add(Integer.toString(bid.getProductId()));
        args.add(Double.toString(bid.getBid()));
        return executor.execUpdate(query.toString(), args);
    }

    @Override
    public List<Bid> getByProduct(int productId) {
        String query  = "SELECT * FROM " + TABLE_NAME + " WHERE " + PRODUCT_ID + " = ?";
        List<String> args = new ArrayList<>();
        args.add(Integer.toString(productId));
        return executor.execQuery(query, args, bidResultHandler);
    }

    @Override
    public List<Bid> getByUser(String userLogin) {
        String query  = "SELECT * FROM " + TABLE_NAME + " WHERE " + USER_LOGIN + " = ?";
        List<String> args = new ArrayList<>();
        args.add(userLogin);
        return executor.execQuery(query, args, bidResultHandler);
    }

    @Override
    public int remove(int id) {
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = ?";
        List<String> args = new ArrayList<>();
        args.add(Integer.toString(id));
        return executor.execUpdate(query, args);
    }

    @Override
    public int removeByUser(String userLogin) {
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + USER_LOGIN + " = ?";
        List<String> args = new ArrayList<>();
        args.add(userLogin);
        return executor.execUpdate(query, args);
    }

    @Override
    public int removeByProduct(int productId) {
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + PRODUCT_ID + " = ?";
        List<String> args = new ArrayList<>();
        args.add(Integer.toString(productId));
        return executor.execUpdate(query, args);
    }

    @Override
    public Bid getGreatestByProduct(int productId) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " +
                BID + " IN (SELECT MAX(" + BID + ") FROM " + TABLE_NAME + ") AND " +
                PRODUCT_ID + " = ?";
        List<String> args = new ArrayList<>();
        args.add(Integer.toString(productId));
        List<Bid> res = executor.execQuery(query, args, bidResultHandler);
        if (!res.isEmpty()){
            return res.get(0);
        }else {
            return null;
        }
    }
}