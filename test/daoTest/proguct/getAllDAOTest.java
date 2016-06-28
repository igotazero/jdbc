package daoTest.proguct;

import controller.dao.FactoryDAO;
import controller.dao.ProductDAO;
import model.Product;

import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/27/2016.
 */
public class getAllDAOTest {
    public static void main(String[] args) {
        ProductDAO dao = FactoryDAO.getConcreteFactory(0).getProductDAO();
        List<Product> list = dao.getAll();
        for(Product p : list){
            System.out.println(p.toString());
        }
    }
}
