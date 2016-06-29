package daoTest.jUnit;

import controller.dao.FactoryDAO;
import controller.dao.ProductDAO;
import model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * Created by Andrei_Zanozin on 6/29/2016.
 */
public class ProductDAO_TEST {
    private ProductDAO dao;

    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        Result result = runner.run(ProductDAO_TEST.class);
        System.out.println("run tests: " + result.getRunCount());
        System.out.println("failed tests: " + result.getFailureCount());
        System.out.println("ignored tests: " + result.getIgnoreCount());
        System.out.println("success: " + result.wasSuccessful());
    }

    @Before
    public void init(){
        dao = FactoryDAO.getConcreteFactory(FactoryDAO.CURRENT_SOURCE).getProductDAO();
    }

    /*5) Add products*/
    @Test
    public void getAllProducts(){
        Product mixer = new Product("koshi", "Mixer", "Just mixer to mix everything", 1500, 100, 24, false);
        Product cola = new Product("koshi", "Coca-Cola", "If you want to drink", 50, 10, 24, false);
        Product cat = new Product("perelmann", "Cat", "Black cat. To avenge the enemies.", 2000, 100, 24, false);
    }
}
