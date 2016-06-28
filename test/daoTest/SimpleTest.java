package daoTest;

import controller.dao.oracle.ParseHandler;
import model.User;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Andrei_Zanozin on 6/27/2016.
 */
public class SimpleTest {
    public static void main(String[] args) {
        User koshi = new User("koshi", "753159", "Koshti", "Paris");
        User clon = new User("koshi", "753159", "Koshi", "Paris");
        System.out.println(clon.equals(koshi));
    }
}
