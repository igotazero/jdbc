package controller.dao.oracle;

import controller.dao.DAOException;
import controller.dao.ResultHandler;
import controller.dao.UserDAO;
import model.Product;
import model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/23/2016.
 */
public class OracleUserDAO implements UserDAO {
    private final String TABLE_NAME = "Users";
    private final String LOGIN = "LOGIN";
    private final String PASSWORD = "PASSWORD";
    private final String NAME = "NAME";
    private final String ADDRESS = "ADDRESS";
    private final Executor<User> executor = new Executor<>();

    private ResultHandler<User> userResultHandler = new ResultHandler<User>() {
        @Override
        public List<User> convert(ResultSet resultSet) {
            List<User> list = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    User user = new User();
                    user.setLogin(resultSet.getString(LOGIN));
                    user.setPassword(resultSet.getString(PASSWORD));
                    user.setName(resultSet.getString(NAME));
                    user.setAddress(resultSet.getString(ADDRESS));
                    list.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
            return list;
        }
    };

    @Override
    public int add(User user) throws DAOException {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ").append(TABLE_NAME).append(" (")
                .append(LOGIN).append(", ")
                .append(PASSWORD).append(", ")
                .append(NAME).append(", ")
                .append(ADDRESS).append(") VALUES (?, ?, ?, ?)");

        List<String> args = new ArrayList<>();
        args.add(user.getLogin());
        args.add(user.getPassword());
        args.add(user.getName());
        args.add(user.getAddress());
        return executor.execUpdate(query.toString(), args);
    }

    @Override
    public User get(String login) throws DAOException {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + LOGIN + " = ?";
        List<String> args = new ArrayList<>();
        args.add(login);
        List<User> res = executor.execQuery(query, args, userResultHandler);
        if (!res.isEmpty()) {
            return res.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<User> getAll() throws DAOException {
        String query = "SELECT * FROM " + TABLE_NAME;
        return executor.execQuery(query, null, userResultHandler);
    }

    public int update(User user) throws DAOException{
        StringBuilder query = new StringBuilder();
        query.append("UPDATE ").append(TABLE_NAME).append(" SET ")
                .append(PASSWORD).append(" = ?, ")
                .append(NAME).append(" = ?, ")
                .append(ADDRESS).append(" = ? WHERE ")
        .append(LOGIN).append(" = ?");

        List<String> args = new ArrayList<>();
        args.add(user.getPassword());
        args.add(user.getName());
        args.add(user.getAddress());
        args.add(user.getLogin());
        return executor.execUpdate(query.toString(), args);
    }

    @Override
    public int remove(String login) throws DAOException {
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + LOGIN + " = ?";
        List<String> args = new ArrayList<>();
        args.add(login);
        return executor.execUpdate(query, args);
    }
}