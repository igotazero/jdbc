package main.java.controller.dao;

import main.java.model.Product;
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
    List<Product> search(String subject, String attribute) throws DAOException;
    int changeOwner(int productID, String newOwner) throws DAOException;
    List<Product> getProductsByUser(String userLogin) throws DAOException;
}
