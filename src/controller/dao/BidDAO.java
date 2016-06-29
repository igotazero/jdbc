package controller.dao;

import model.Bid;

import java.util.List;

public interface BidDAO {
    int add(Bid bid) throws DAOException;
    int remove(int id) throws DAOException;
    int removeByUser(String userLogin) throws DAOException;
    int removeByProduct(int productId) throws DAOException;
    List<Bid> getByProduct(int productId) throws DAOException;
    List<Bid> getByUser(String userLogin) throws DAOException;
    Bid getGreatestByProduct(int productId) throws DAOException;
}
