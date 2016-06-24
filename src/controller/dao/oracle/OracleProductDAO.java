package controller.dao.oracle;

import controller.dao.ProductDAO;
import controller.dao.ResultHandler;
import model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                    
                }
            }catch (SQLException e){
                e.printStackTrace();
                return null;
            }

        }
    }

    public List<Product> getAll(){
        String query = "SELECT * FROM ?";
        List<String> args = new ArrayList<>();
        args.add(tableName);
        Executor<Product> executor = new Executor<>();
        List<Product> result = executor.execQuery(query, args,

    }
}
