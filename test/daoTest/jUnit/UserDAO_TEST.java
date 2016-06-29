package daoTest.jUnit;

import controller.dao.FactoryDAO;
import controller.dao.UserDAO;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Andrei_Zanozin on 6/28/2016.
 */
public class UserDAO_TEST {
    UserDAO dao;

    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(UserDAO_TEST.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }

    @Before
    public void init(){
        dao = FactoryDAO.getConcreteFactory(FactoryDAO.CURRENT_SOURCE).getUserDAO();
    }

    @Test
    public void getAll_TEST(){
        User koshi = new User("koshi", "753159", "Koshi", "Paris");
        User riemann = new User("riemann", "pass", "Riemann", "Paris");
        User fibonachi = new User("fibonachi", "1.1.2.3.5.8", "Fibonachi", "Italy, Piza");

        List<User> res =  dao.getAll();
        assertTrue(res.contains(koshi));
        assertTrue(res.contains(riemann));
        assertTrue(res.contains(fibonachi));
    }

    @Test
    public void addNewUser_TEST(){
        User perelmann = new User("perelmann", "candy", "Perelmann", "Russia");
        dao.add(perelmann);
        List<User> res =  dao.getAll();
        assertTrue(res.contains(perelmann));
    }

    @Test(expected = SQLIntegrityConstraintViolationException.class)
    public void addExistingUser_TEST(){
        User gauss = new User("gauss", "rand", "Иога́нн Карл Фри́дрих Га́усс", "Германия");
        dao.add(gauss);
    }
}