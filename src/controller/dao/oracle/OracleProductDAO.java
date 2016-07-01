package controller.dao.oracle;

import controller.dao.DAOException;
import controller.dao.ProductDAO;
import controller.dao.ResultHandler;
import model.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/23/2016.
 */
public class OracleProductDAO implements ProductDAO {
    public static final String TABLE_NAME = "Products";
    public static final String ID = "ID";
    public static final String SELLER_ID = "SELLERID";
    public static final String NAME = "NAME";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String PRICE = "PRICE";
    public static final String GAP = "GAP";
    public static final String HOURS = "HOURS";
    public static final String START_BIDDING_DATE = "STARTBIDDINGDATE";
    public static final String BUY_NOW = "BUYNOW";
    private static final Executor<Product> executor = new Executor<>();

    private ResultHandler<Product> productResultHandler = new ResultHandler<Product>() {
        @Override
        public List<Product> convert(ResultSet resultSet) throws DAOException {
            List<Product> list = new ArrayList<>();
            try {
                while(resultSet.next()){
                    Product product = new Product();
                    product.setId(resultSet.getInt(ID));
                    product.setSellerLogin(resultSet.getString(SELLER_ID));
                    product.setName(resultSet.getString(NAME));
                    product.setDescription(resultSet.getString(DESCRIPTION));
                    product.setPrice(resultSet.getDouble(PRICE));
                    product.setGap(resultSet.getDouble(GAP));
                    product.setHours(resultSet.getInt(HOURS));
                    Timestamp timestamp = resultSet.getTimestamp(START_BIDDING_DATE);
                    if (timestamp != null){
                        product.setStartBiddingDate(new Date(timestamp.getTime()));
                    }else {
                        product.setStartBiddingDate(null);
                    }
                    product.setBuyNow(ParseHandler.convert(resultSet.getInt(BUY_NOW)));
                    list.add(product);
                }
            }catch (SQLException e){
                throw new DAOException("Reading from the database error", e);
            }
            return list;
        }
    };

    @Override
    public int update(Product product) throws DAOException {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE ").append(TABLE_NAME).append(" SET ");
        query.append(SELLER_ID).append(" = ?, ");
        query.append(NAME).append(" = ?, ");
        query.append(DESCRIPTION).append(" = ?, ");
        query.append(PRICE).append(" = ?, ");
        query.append(GAP).append(" = ?, ");
        query.append(HOURS).append(" = ?, ");
        query.append(START_BIDDING_DATE).append(" = (TO_DATE(?, '").append(ParseHandler.getOracleFormat()).append("'), ");
        query.append(BUY_NOW).append(" = ?, ");
        query.append("WHERE ").append(ID).append(" = ?");

        List<String> args = new ArrayList<>();
        args.add(product.getSellerLogin());
        args.add(product.getName());
        args.add(product.getDescription());
        args.add(Double.toString(product.getPrice()));
        args.add(Double.toString(product.getGap()));
        args.add(Integer.toString(product.getHours()));
        args.add(ParseHandler.dateToString(product.getStartBiddingDate()));
        args.add(Integer.toString(ParseHandler.convert(product.isBuyNow())));
        args.add(Integer.toString(product.getId()));
        return executor.execUpdate(query.toString(), args);
    }

    @Override
    public Product get(int id) throws DAOException {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = ?";
        List<String> args = new ArrayList<String>();
        args.add(Integer.toString(id));
        List<Product> res = executor.execQuery(query, args, productResultHandler);
        if (!res.isEmpty()){
            return res.get(0);
        }else {
            return null;
        }
    }

    @Override
    public int add(Product product) throws DAOException{
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ").append(TABLE_NAME);
        query.append(" (")
                .append(ID).append(", ")
                .append(SELLER_ID).append(", ")
                .append(NAME).append(", ")
                .append(DESCRIPTION).append(", ")
                .append(PRICE).append(", ")
                .append(GAP).append(", ")
                .append(HOURS).append(", ")
                .append(START_BIDDING_DATE).append(", ")
                .append(BUY_NOW).append(") ");
        query.append("VALUES (products_seq.nextval, ? , ?, ?, ?, ?, ?, SYSDATE, ?)");

        List<String> args = new ArrayList<>();
        args.add(product.getSellerLogin());
        args.add(product.getName());
        args.add(product.getDescription());
        args.add(Double.toString(product.getPrice()));
        args.add(Double.toString(product.getGap()));
        args.add(Integer.toString(product.getHours()));
        args.add(Integer.toString(ParseHandler.convert(product.isBuyNow())));
        return executor.execUpdate(query.toString(), args);
    }

    @Override
    public List<Product> getAll() throws DAOException{
        String query = "SELECT * FROM " + TABLE_NAME;
        List<Product> result = executor.execQuery(query, null, productResultHandler);
        return result;
    }

    @Override
    public int remove(int id) throws DAOException {
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + id + " = ?";
        List<String> args = new ArrayList<>();
        args.add(Integer.toString(id));
        return executor.execUpdate(query, args);
    }

    @Override
    public List<Product> search(String subject, String attribute) throws DAOException {
        subject = subject.trim();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE "
                + attribute + " LIKE ? OR "
                + attribute + " LIKE lower(?) OR "
                + attribute + " LIKE upper(?)";
        List<String> args = new ArrayList<>();
        String argument = "%" + subject + "%";
        for (int i = 0; i < 3; i++) {
            args.add(argument);
        }
        return executor.execQuery(query, args, productResultHandler);
    }

    public int changeOwner(int productID, String newOwner) throws DAOException{
        String query = "UPDATE " + TABLE_NAME + " SET " + SELLER_ID + " = ? WHERE " +
                ID + " = ?";
        List<String> args = new ArrayList<>();
        args.add(newOwner);
        args.add(Integer.toString(productID));
        return executor.execUpdate(query, args);
    }
}