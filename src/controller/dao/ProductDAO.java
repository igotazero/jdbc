package controller.dao;

import model.Product;

import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/23/2016.
 */
public interface ProductDAO {
    List<Product> getAll() throws DAOException;
    Product get(int id) throws DAOException;
    int add(Product product) throws DAOException;
    int update(Product product) throws DAOException;
    int remove(int id) throws DAOException;
}
