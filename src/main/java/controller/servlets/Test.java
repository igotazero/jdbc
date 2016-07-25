package main.java.controller.servlets;

import main.java.controller.dao.BidDAO;
import main.java.controller.dao.DAOException;
import main.java.controller.dao.FactoryDAO;

/**
 * Created by Andrei_Zanozin on 7/26/2016.
 */
public class Test {
    public static void main(String[] args) throws DAOException {
        BidDAO dao = FactoryDAO.getConcreteFactory(FactoryDAO.CURRENT_SOURCE).getBidDAO();
        System.out.println(dao.getGreatestByProduct(6));
    }
}
