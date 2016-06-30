package controller.dao.oracle;

import controller.dao.DAOException;
import controller.dao.ResultHandler;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/23/2016.
 */
public class Executor<T>  {
    private static final Logger log = Logger.getLogger(Executor.class);

    public int execUpdate(String query, List<String> args) throws DAOException{
        try(Connection connection = Connector.getConnection()) {
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(query);
                fillArguments(statement, args);
                return statement.executeUpdate();
            }else {
                return 0;
            }
        }catch (SQLIntegrityConstraintViolationException e){
            toLog(e);
            throw new DAOException("Unique constraint violated", e);
        }catch (SQLException e){
            toLog(e);
            throw new DAOException("Failed update table", e);
        }
    }

    public List<T> execQuery(String query, List<String> args, ResultHandler<T> resultHandler) throws DAOException{
        try(Connection connection = Connector.getConnection()) {
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(query);
                fillArguments(statement, args);
                ResultSet resultSet = statement.executeQuery();
                return resultHandler.convert(resultSet);
            }else {
                return null;
            }
        }catch (SQLException e){
            toLog(e);
            throw new DAOException("Failed getting query", e);
        }
    }

    private void fillArguments(PreparedStatement statement, List<String> args) throws SQLException{
        if (args != null) {
            for (int i = 1; i <= args.size(); i++) {
                statement.setString(i, args.get(i - 1));
            }
        }
    }

    private void toLog(Exception e){
        log.error(e.getMessage() + " // " + Arrays.toString(e.getStackTrace()));
    }
}
