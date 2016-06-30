package daoTest.jUnit;

import controller.dao.DAOException;
import controller.dao.FactoryDAO;
import controller.dao.ProductDAO;
import controller.dao.oracle.OracleProductDAO;
import controller.dao.oracle.ParseHandler;
import model.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import java.util.List;
import static org.junit.Assert.assertTrue;


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
    public void getAllProducts() throws DAOException{
        Product mixer = new Product(111, "koshi", "Mixer", "Just mixer to mix everything", 1500, 100, 24, ParseHandler.stringToDate("2016-06-29 15:00:00"), false);
        Product cola = new Product(112, "koshi", "Coca-Cola", "If you want to drink", 50, 10, 24, ParseHandler.stringToDate("2016-06-29 15:00:00"), false);
        Product cat = new Product(113, "perelmann", "Cat", "Black cat. To avenge the enemies.", 2000, 100, 24, ParseHandler.stringToDate("2016-06-29 15:00:00"), false);

        List<Product> res =  dao.getAll();
        assertTrue(res.contains(mixer));
        assertTrue(res.contains(cola));
        assertTrue(res.contains(cat));
    }

    /*6) Search by substring*/
    @Test
    public void search_TEST() throws DAOException{
        Product diesel = new Product();
        diesel.setSellerLogin("riemann");
        diesel.setName("Diesel generator");
        diesel.setDescription("You want to be powerfull? By the diesel!");
        diesel.setPrice(5600);
        diesel.setGap(100);
        diesel.setHours(24);
        diesel.setBuyNow(false);
        dao.add(diesel);

        List<Product> res = dao.search("generator", OracleProductDAO.NAME);
        Product product = null;
        for(Product p : res){
            if (p.getName().equals(diesel.getName())){
                product = p;
            }
        }
        assertTrue(product != null);
        assertTrue(product.getDescription().equals(diesel.getDescription()));
    }

    /*7) Search by product ID*/

    @Test
    public void search_by_id_TEST() throws DAOException{
        Product table = new Product(114, "koshi", "Table", "Just table", 1650, 50, 24, ParseHandler.stringToDate("2016-06-29 15:00:00"), true);
        Product res = dao.get(114);
        assertTrue(res.equals(table));
    }

    /*8) Search Product by seller*/
    @Test
    public void search_by_seller_TEST() throws DAOException{
        Product table = new Product(115, "agent", "Table", "Nothing", 1650, 50, 24, ParseHandler.stringToDate("2016-06-29 15:00:00"), true);
        Product product = dao.search("agent", OracleProductDAO.SELLER_ID).get(0);
        if (product != null){
            assertTrue(product.equals(table));
        }
    }

    @Test
    public void add_new_Product() throws DAOException{
        Product soap = new Product(0, "agent", "Soap", "To wash", 40, 0, 24, ParseHandler.stringToDate("2016-06-29 15:00:00"), true);
        List<Product> res = dao.getAll();
        Product product = null;
        for (Product p : res){
            if (p.getName().equals(soap.getName()) && p.getSellerLogin().equals(soap.getSellerLogin())){
                product = p;
                break;
            }
        }
        if (product == null) {
            dao.add(soap);
            res = dao.getAll();
            for (Product p : res) {
                if (p.getName().equals(soap.getName()) && p.getSellerLogin().equals(soap.getSellerLogin())) {
                    product = p;
                    break;
                }
            }
        }
        if (product != null){
            assertTrue(product.getPrice() == soap.getPrice());
            assertTrue(product.getGap() == soap.getGap());
            assertTrue(product.getDescription().equals(soap.getDescription()));
            assertTrue(product.isBuyNow() == soap.isBuyNow());
        }
    }


}
