package java.controller.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    final private static String driverName = "oracle.jdbc.driver.OracleDriver";
    final private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    final private static String username = "andrew";
    final private static String password = "753159";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, username, password);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    static {
        try {
            Driver driver = (Driver) Class.forName(driverName).newInstance();
            DriverManager.registerDriver(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
