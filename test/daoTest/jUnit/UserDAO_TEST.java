package daoTest.jUnit;

import controller.dao.FactoryDAO;
import controller.dao.UserDAO;
import model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Andrei_Zanozin on 6/28/2016.
 */
public class UserDAO_TEST {
    User koshi;
    User riemann;
    User fibonachi;
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
        koshi = new User("koshi", "753159", "Koshi", "Paris");
        riemann = new User("riemann", "pass", "Riemann", "Paris");
        fibonachi = new User("fibonachi", "1.1.2.3.5.8", "Fibonachi", "Italy, Piza");

        dao = FactoryDAO.getConcreteFactory(FactoryDAO.CURRENT_SOURCE).getUserDAO();
    }

    @Test
    public void getAll_TEST(){
        List<User> res =  dao.getAll();
        assertEquals(3, res.size());
        assertTrue(res.contains(koshi));
        assertTrue(res.contains(riemann));
        assertTrue(res.contains(fibonachi));
    }
}