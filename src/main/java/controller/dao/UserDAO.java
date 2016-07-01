package main.java.controller.dao;

import main.java.model.User;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/23/2016.
 */
public interface UserDAO {
    User get(String login) throws DAOException;
    List<User> getAll() throws DAOException;
    int add(User user) throws DAOException;
    int update(User user) throws DAOException;
    int remove(String login) throws DAOException;
}
