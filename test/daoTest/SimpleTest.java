package daoTest;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Andrei_Zanozin on 6/27/2016.
 */
public class SimpleTest {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        System.out.println(timestamp.toString());
    }
}
