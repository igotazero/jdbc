package controller.dao;

import model.Product;

import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/23/2016.
 */
public interface ProductDAO {
    List<Product> getAll();
    void add(Product product);
}
