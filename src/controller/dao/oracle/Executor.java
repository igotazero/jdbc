package controller.dao.oracle;

import controller.dao.ResultHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/23/2016.
 */
public class Executor<T> {
    public int execUpdate(String query, List<String> args){
        try(Connection connection = Connector.getConnection()) {
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(query);
                fillArguments(statement, args);
                return statement.executeUpdate();
            }else {
                return 0;
            }
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    public List<T> execQuery(String query, List<String> args, ResultHandler<T> resultHandler){
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
            e.printStackTrace();
            return null;
        }
    }

    private void fillArguments(PreparedStatement statement, List<String> args) throws SQLException{
        for (int i = 0; i < args.size(); i++){
            statement.setString(i + 1, args.get(i));
        }
    }
}
