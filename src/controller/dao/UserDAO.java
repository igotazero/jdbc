package controller.dao;

import model.User;

import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/23/2016.
 */
public interface UserDAO {
    User get(String login);
    List<User> getAll();
    int add(User user);
    int update(User user);
    int remove(String login);
}
