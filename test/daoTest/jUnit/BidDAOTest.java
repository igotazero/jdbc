package daoTest.jUnit;

import main.java.controller.dao.BidDAO;
import main.java.controller.dao.DAOException;
import main.java.controller.dao.FactoryDAO;
import main.java.controller.dao.ProductDAO;
import main.java.controller.dao.oracle.OracleProductDAO;
import main.java.controller.dao.oracle.ParseHandler;
import main.java.model.Bid;
import main.java.model.Product;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import static org.junit.Assert.assertTrue;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/30/2016.
 */
public class BidDAOTest {
    BidDAO dao;

    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(BidDAOTest.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

    /*11. Change owner*/
    @Test
    public void changeOwner_TEST() throws DAOException{
        Product sun = new Product(0, "riemann", "Sun", "If you want some light in your life", 1500, 100, 24, ParseHandler.stringToDate("2016-06-29 15:00:00"), false);
        ProductDAO productDAO = FactoryDAO.getConcreteFactory(FactoryDAO.CURRENT_SOURCE).getProductDAO();
        List<Product> res = productDAO.search("Sun", OracleProductDAO.NAME);
        Product product;
        if (res.isEmpty()){
            productDAO.add(sun);
            changeOwner_TEST();
        }else {
            product = res.get(0);
            Bid best = dao.getGreatestByProduct(product.getId());
            if (best != null){
                productDAO.changeOwner(product.getId(), best.getUserLogin());
                Product change = productDAO.get(product.getId());
                if (change.getSellerLogin().equals(best.getUserLogin())){
                    assert true;
                }
            }
        }
    }

    /*12. Add Bid*/
    @Test
    public void addBid() throws DAOException{
        Bid anyBid = new Bid(0, "koshi", 9, 2000);
        dao.add(anyBid);
        List<Bid> res = dao.getAll();
        for (Bid b : res){
            if (b.getUserLogin().equals(anyBid.getUserLogin())
                    && b.getProductId() == anyBid.getProductId()
                    && b.getBid() == anyBid.getBid()){
                assert true;
            }
        }
    }

    /*13. Best Bid*/
    @Test
    public void getBestBid_TEST() throws DAOException{
        Bid bestBid = new Bid(116, "koshi", 9, 2200);
        Bid res = dao.getGreatestByProduct(9);
        assertTrue(res.equals(bestBid));
    }

    /*---Additional tests ---*/

    @Test
    public void getNonexistentBid() throws DAOException{
        assertTrue(dao.getByUser("nan").isEmpty());
        assertTrue(dao.getByProduct(666666666).isEmpty());
    }

    @Test
    public void addExistentBid() throws DAOException{
        thrown.expect(DAOException.class);
        thrown.expectMessage("Unique constraint violated");
        List<Bid> res = dao.getAll();
        Bid bid = null;
        if (!res.isEmpty()){
            bid = res.get(0);
        }else {
            assert true;
        }
        dao.add(bid);
    }
}