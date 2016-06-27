package daoTest;

import controller.dao.FactoryDAO;
import controller.dao.ProductDAO;
import model.Product;

/**
 * Created by Andrei_Zanozin on 6/27/2016.
 */
public class getProductDAO_Test {
    public static void main(String[] args) {
        ProductDAO dao = FactoryDAO.getConcreteFactory(0).getProductDAO();
        for(int i = 0; i < 20; i++){
            Product product = dao.get(i);
            System.out.println(product);
        }
    }
}