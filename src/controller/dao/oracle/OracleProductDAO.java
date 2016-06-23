package controller.dao.oracle;

import controller.dao.ItemDAO;
import model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/23/2016.
 */
public class OracleProductDAO implements ItemDAO {
    private final String tableName = "Products";

    public List<Product> getAll(){
        String query = "SELECT * FROM ?";
        List<String> args = new ArrayList<>();
        args.add(tableName);
        Executor<Product> executor = new Executor<>();
        List<Product> result = executor.execQuery(query, arg, 
    }
}
