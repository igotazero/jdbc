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
    private ResultHandler<Product> resultHandlerProduct = new ResultHandler<Product>() {
        @Override
        public List<Product> convert(ResultSet resultSet) {
            List<Product> list = new ArrayList<>();
            try {
                while(resultSet.next()){
                    Product product = new Product();
                    product.setId(resultSet.getInt("ID"));
                    product.setSellerLogin(resultSet.getString("SELLERID"));
                    product.setName(resultSet.getString("NAME"));
                    product.setDescription(resultSet.getString("DESCRIPTION"));
                    product.setPrice(resultSet.getDouble("PRICE"));
                    product.setGap(resultSet.getDouble("GAP"));
                    product.setHours(resultSet.getInt("HOURS"));
                    Timestamp timestamp = resultSet.getTimestamp("STARTBIDDINGDATE");
                    if (timestamp != null){
                        product.setStartBiddingDate(new Date(timestamp.getTime()));
                    }else {
                        product.setStartBiddingDate(null);
                    }
                    product.setBuyNow(ParseHandler.convert(resultSet.getInt("BUYNOW")));
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
        String query = "UPDATE " + tableName + " SET NAME = ? WHERE ID = ?";
        List<String> args = new ArrayList<>();
        args.add(product.getName());
        args.add(Integer.toString(product.getId()));
        Executor<Product> executor = new Executor<>();
        return executor.execUpdate(query, args);
    }
  /*
    @Override
    public int update(Product product) {
        String query = "UPDATE " + tableName + " SET SELLERID = ?, NAME = ?, DESCRIPTION = ?, " +
                "PRICE = ?, GAP = ?, HOURS = ?, STARTBIDDINGDATE = ?, BUYNOW = ? " +
                "WHERE ID = ?";
        List<String> args = new ArrayList<>();
        args.add(product.getSellerLogin());
        args.add(product.getName());
        args.add(product.getDescription());
        args.add(Double.toString(product.getPrice()));
        args.add(Double.toString(product.getGap()));
        args.add(Integer.toString(product.getHours()));
        Timestamp timestamp = new Timestamp(product.getStartBiddingDate().getTime());
        args.add(timestamp.toString());
        //args.add("27-JUN-16");
        args.add(Integer.toString(ParseHandler.convert(product.isBuyNow())));
        args.add(Integer.toString(product.getId()));
        Executor<Product> executor = new Executor<>();
        return executor.execUpdate(query, args);
    }
*/
    @Override
    public Product get(int id) {
        String query = "SELECT * FROM " + tableName + " WHERE ID = ?";
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
        String query = "INSERT INTO " + tableName +
                " (ID, SELLERID, NAME, DESCRIPTION, PRICE, GAP, HOURS, STARTBIDDINGDATE, BUYNOW) " +
                "VALUES (products_seq.nextval, ? , ?, ?, ?, ?, ?, SYSDATE, ?)";
        List<String> args = new ArrayList<>();
        args.add(product.getSellerLogin());
        args.add(product.getName());
        args.add(product.getDescription());
        args.add(Double.toString(product.getPrice()));
        args.add(Double.toString(product.getGap()));
        args.add(Integer.toString(product.getHours()));
        args.add(Integer.toString(ParseHandler.convert(product.isBuyNow())));
        Executor<Product> executor = new Executor<>();
        return executor.execUpdate(query, args);
    }

    @Override
    public List<Product> getAll(){
        String query = "SELECT * FROM " + tableName;
        Executor<Product> executor = new Executor<>();
        List<Product> result = executor.execQuery(query, null, resultHandlerProduct);
        return result;
    }
}
