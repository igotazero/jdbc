package controller.dao.oracle;

import controller.dao.ProductDAO;
import controller.dao.ResultHandler;
import model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
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
                    product.setStartBiddingDate(resultSet.getDate("STARTBIDDINGDATE"));
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
    public void add(Product product){
        String query = "INSERT INTO ? " +
                "(ID, SELLERID, NAME, DESCRIPTION, PRICE, GAP, HOURS, STARTBIDDINGDATE, BUYNOW) " +
                "VALUES (products_seq.nextval, ? , ?, ?, ?, ?, ?, ?, ?)";
        List<String> args = new ArrayList<>();
        args.add(tableName);
        args.add(product.getSellerLogin());
        args.add(product.getName());
        args.add(product.getDescription());
        args.add(Double.toString(product.getPrice()));
        args.add(Double.toString(product.getGap()));
        args.add(Integer.toString(product.getHours()));
        args.add(ParseHandler.dateToString(product.getStartBiddingDate()));
        args.add(Integer.toString(ParseHandler.convert(product.isBuyNow())));
        Executor<Product> executor = new Executor<>();
        executor.execUpdate(query, args);
    }

    @Override
    public List<Product> getAll(){
        String query = "SELECT * FROM ?";
        List<String> args = new ArrayList<>();
        args.add(tableName);
        Executor<Product> executor = new Executor<>();
        List<Product> result = executor.execQuery(query, args, resultHandlerProduct);
        return result;
    }
}
