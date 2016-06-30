package daoTest.jUnit;

import controller.dao.BidDAO;
import controller.dao.DAOException;
import controller.dao.FactoryDAO;
import model.Bid;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import static org.junit.Assert.assertTrue;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/30/2016.
 */
public class BidDAO_TEST {
    BidDAO dao;

    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(BidDAO_TEST.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }

    @Before
    public void init(){
        dao = FactoryDAO.getConcreteFactory(FactoryDAO.CURRENT_SOURCE).getBidDAO();
    }

    /*10) Get Bids by Product*/
    @Test
    public void getBidsByProduct_TEST() throws DAOException{
        Bid one = new Bid(111, "koshi", 9, 1700);
        Bid two = new Bid(112, "koshi", 9, 1750);
        Bid three = new Bid(113, "koshi", 9, 1800);

        List<Bid> res = dao.getAll();
        assertTrue(res.contains(one));
        assertTrue(res.contains(two));
        assertTrue(res.contains(three));
    }

    
}
