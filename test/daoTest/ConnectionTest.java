package daoTest;

import controller.dao.oracle.Connector;
import java.sql.Connection;

public class ConnectionTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Connection connection = Connector.getConnection();
            if (connection != null) {
                System.out.println("connection " + i + " established");
            } else {
                System.out.println("connection not established");
            }
        }
    }
}