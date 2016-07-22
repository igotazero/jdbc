package main.java.controller;

import main.java.controller.dao.DAOException;
import main.java.controller.dao.FactoryDAO;
import main.java.controller.dao.UserDAO;
import main.java.model.User;

/**
 * Created by Andrei_Zanozin on 7/22/2016.
 */
public class Test {
    public static void main(String[] args) throws DAOException {
        UserDAO dao = FactoryDAO.getConcreteFactory(FactoryDAO.CURRENT_SOURCE).getUserDAO();
        User user = dao.get("gauss");
        if (user == null){
            System.out.println(user);
        }else {
            System.out.println(user.toString());
        }
    }
}
