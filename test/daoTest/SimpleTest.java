package daoTest;

import controller.dao.oracle.ParseHandler;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Andrei_Zanozin on 6/27/2016.
 */
public class SimpleTest {
    public static void main(String[] args) {
        System.out.println(ParseHandler.dateToString(new Date()));
    }
}
