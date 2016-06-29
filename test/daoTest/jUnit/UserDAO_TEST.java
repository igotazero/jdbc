package daoTest.jUnit;

import controller.dao.DAOException;
import controller.dao.FactoryDAO;
import controller.dao.UserDAO;
import model.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
    private UserDAO dao;

    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(UserDAO_TEST.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init(){
        dao = FactoryDAO.getConcreteFactory(FactoryDAO.CURRENT_SOURCE).getUserDAO();
    }

    /*1) Add* all users*/
    @Test
    public void getAll_TEST() throws DAOException{
        User koshi = new User("koshi", "753159", "Koshi", "Paris");
        User riemann = new User("riemann", "pass", "Riemann", "Paris");
        User fibonachi = new User("fibonachi", "1.1.2.3.5.8", "Fibonachi", "Italy, Piza");

        List<User> res =  dao.getAll();
        assertTrue(res.contains(koshi));
        assertTrue(res.contains(riemann));
        assertTrue(res.contains(fibonachi));
    }

    /*2) Create new user*/
    @Test
    public void addNewUser_TEST() throws DAOException{
        User perelmann = new User("perelmann", "candy", "Perelmann", "Russia");
        dao.add(perelmann);
        List<User> res =  dao.getAll();
        assertTrue(res.contains(perelmann));
    }

    @Test
    public void addExistingUser_TEST() throws DAOException{
        thrown.expect(DAOException.class);
        thrown.expectMessage("Unique constraint violated");
        User gauss = new User("gauss", "rand", "Иога́нн Карл Фри́дрих Га́усс", "Германия");
        dao.add(gauss);
    }

    /*3) Get user by login*/
    @Test
    public void getUserByLogin_TEST() throws DAOException{
        User viet = new User("viett", "myTheoremIsSoCool", "Viett", "Paris");
        User res = dao.get("login");
        assertEquals(viet, res);
    }

    @Test
    public void getNonexistentLogun_TEST() throws DAOException{
        thrown.expect(DAOException.class);
        thrown.expectMessage("Login does not exist");
        User res = dao.get("login");
    }

    /*4) Change user data*/
    @Test
    public void changeUserData() throws DAOException{
        User agent = new User("agent", "hoho", "Smith", "Default sity");
        User res = dao.get("agent");
        res.setPassword(agent.getPassword());
        res.setName(agent.getName());
        res.setAddress(agent.getAddress());
        dao.update(res);
        User finRes = dao.get("agent");
        assertTrue(finRes.equals(agent));
    }
}