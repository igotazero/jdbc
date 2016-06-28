package controller.dao.oracle;

import controller.dao.UserDAO;
import model.User;

/**
 * Created by Andrei_Zanozin on 6/23/2016.
 */
public class OracleUserDAO implements UserDAO {
    private final String tableName = "Users";
    private final String login = "LOGIN";
    private final String password = "PASSWORD";
    private final String name = "NAME";
    private final String adress = "ADDRESS";

    @Override
    public int add(User user) {
        String query = "INSERT INTO " + tableName +
                " (Login, Password, Name, Adress) VALUES " +
                "?, ?, ?, ?";

    }
}