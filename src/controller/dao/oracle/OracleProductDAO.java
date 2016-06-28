package controller.dao.oracle;

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
    private final String tableName = "Products";
    private final String id = "ID";
    private final String sellerId = "SELLERID";
    private final String name = "NAME";
    private final String description = "DESCRIPTION";
    private final String price = "PRICE";
    private final String gap = "GAP";
    private final String hours = "HOURS";
    private final String startBiddingDate = "STARTBIDDINGDATE";
    private final String buyNow = "BUYNOW";

    private ResultHandler<Product> resultHandlerProduct = new ResultHandler<Product>() {
        @Override
        public List<Product> convert(ResultSet resultSet) {
            List<Product> list = new ArrayList<>();
            try {
                while(resultSet.next()){
                    Product product = new Product();
                    product.setId(resultSet.getInt(id));
                    product.setSellerLogin(resultSet.getString(sellerId));
                    product.setName(resultSet.getString(name));
                    product.setDescription(resultSet.getString(description));
                    product.setPrice(resultSet.getDouble(price));
                    product.setGap(resultSet.getDouble(gap));
                    product.setHours(resultSet.getInt(hours));
                    Timestamp timestamp = resultSet.getTimestamp(startBiddingDate);
                    if (timestamp != null){
                        product.setStartBiddingDate(new Date(timestamp.getTime()));
                    }else {
                        product.setStartBiddingDate(null);
                    }
                    product.setBuyNow(ParseHandler.convert(resultSet.getInt(buyNow)));
                    list.add(product);
                }
            }catch (SQLException e){
                e.printStackTrace();
                return null;
            }
            return list;
        }
    };

    @Override
    public int update(Product product) {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE ").append(tableName).append(" SET ");
        query.append(sellerId).append(" = ?, ");
        query.append(name).append(" = ?, ");
        query.append(description).append(" = ?, ");
        query.append(price).append(" = ?, ");
        query.append(gap).append(" = ?, ");
        query.append(hours).append(" = ?, ");
        query.append(startBiddingDate).append(" = (TO_DATE(?, '").append(ParseHandler.getOracleFormat()).append("'), ");
        query.append(buyNow).append(" = ?, ");
        query.append("WHERE ").append(id).append(" = ?");

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
        Executor<Product> executor = new Executor<>();
        return executor.execUpdate(query.toString(), args);
    }

    @Override
    public Product get(int id) {
        String query = "SELECT * FROM " + tableName + " WHERE " + id + " = ?";
        Executor<Product> executor = new Executor<>();
        List<String> args = new ArrayList<String>();
        args.add(Integer.toString(id));
        List<Product> res = executor.execQuery(query, args, resultHandlerProduct);
        if (!res.isEmpty()){
            return res.get(0);
        }else {
            return null;
        }
    }

    @Override
    public int add(Product product){
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ").append(tableName);
        query.append(" (")
                .append(id).append(", ")
                .append(sellerId).append(", ")
                .append(name).append(", ")
                .append(description).append(", ")
                .append(price).append(", ")
                .append(gap).append(", ")
                .append(hours).append(", ")
                .append(startBiddingDate).append(", ")
                .append(buyNow).append(") ");
        query.append("VALUES (products_seq.nextval, ? , ?, ?, ?, ?, ?, SYSDATE, ?)");

        List<String> args = new ArrayList<>();
        args.add(product.getSellerLogin());
        args.add(product.getName());
        args.add(product.getDescription());
        args.add(Double.toString(product.getPrice()));
        args.add(Double.toString(product.getGap()));
        args.add(Integer.toString(product.getHours()));
        args.add(Integer.toString(ParseHandler.convert(product.isBuyNow())));
        Executor<Product> executor = new Executor<>();
        return executor.execUpdate(query.toString(), args);
    }

    @Override
    public List<Product> getAll(){
        String query = "SELECT * FROM " + tableName;
        Executor<Product> executor = new Executor<>();
        List<Product> result = executor.execQuery(query, null, resultHandlerProduct);
        return result;
    }

    @Override
    public int remove(int id) {
        String query = "DELETE FROM " + tableName + " WHERE " + id + " = ?";
        List<String> args = new ArrayList<>();
        args.add(Integer.toString(id));
        Executor<Product> executor = new Executor<>();
        return executor.execUpdate(query, args);
    }
}