package main.java.controller.dao;

import main.java.model.Deal;

import java.util.List;

/**
 * Created by Andrei_Zanozin on 7/26/2016.
 */
public interface DealDAO {
    int add(Deal deal) throws DAOException;
    Deal get(int productID) throws DAOException;
    List<Deal> getDealingsByUser(String userLogin) throws DAOException;
}