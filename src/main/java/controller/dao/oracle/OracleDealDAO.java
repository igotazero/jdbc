package main.java.controller.dao.oracle;

import main.java.controller.dao.DAOException;
import main.java.controller.dao.DealDAO;
import main.java.controller.dao.ResultHandler;
import main.java.model.Deal;
import main.java.model.Product;
import main.java.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 7/26/2016.
 */
public class OracleDealDAO implements DealDAO {
    private final String TABLE_NAME = "Dealings";
    private final String PRODUCT_ID = "PRODUCTID";
    private final String BID_PRICE = "BIDPRICE";
    private final String SELLER_ID = "SELLERID";
    private final String BUYER_ID = "BUYERID";
    private final String DEAL_DATE = "DEALDATE";
    private final Executor<Deal> executor = new Executor<>();
    private ResultHandler<Deal> dealResultHandler = new ResultHandler<Deal>() {
        @Override
        public List<Deal> convert(ResultSet resultSet) throws DAOException {
            List<Deal> list = new ArrayList<>();
            try {
                while(resultSet.next()){
                    Deal deal = new Deal();
                    deal.setProductId(resultSet.getInt(PRODUCT_ID));
                    deal.setBidPrice(resultSet.getDouble(BID_PRICE));
                    deal.setSellerId(resultSet.getString(SELLER_ID));
                    deal.setBuyerId(resultSet.getString(BUYER_ID));
                    Timestamp timestamp = resultSet.getTimestamp(DEAL_DATE);
                    deal.setDealDate(new Date(timestamp.getTime()));
                    list.add(deal);
                }
            }catch (SQLException e){
                throw new DAOException("Reading from the database error", e);
            }
            return list;
        }
    };
    @Override
    public int add(Deal deal) throws DAOException {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ").append(TABLE_NAME).append(" (")
                .append(PRODUCT_ID).append(", ")
                .append(BID_PRICE).append(", ")
                .append(SELLER_ID).append(", ")
                .append(BUYER_ID).append(", ")
                .append(DEAL_DATE).append(") ")
                .append("VALUES (?, ?, ?, ?, TO_DATE(?, '").append(ParseHandler.getOracleFormat()).append("'))");

        List<String> args = new ArrayList<>();
        args.add(Integer.toString(deal.getProductId()));
        args.add(Double.toString(deal.getBidPrice()));
        args.add(deal.getSellerId());
        args.add(deal.getBuyerId());
        args.add(ParseHandler.dateToString(deal.getDealDate()));
        return executor.execUpdate(query.toString(), args);
    }

    @Override
    public Deal get(int productID) throws DAOException {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + PRODUCT_ID + " = ?";
        List<String> args = new ArrayList<>();
        args.add(Integer.toString(productID));
        List<Deal> res = executor.execQuery(query, args, dealResultHandler);
        if (!res.isEmpty()){
            return res.get(0);
        }else {
            return null;
        }
    }
}
