package daoTest.proguct;

import controller.dao.FactoryDAO;
import controller.dao.ProductDAO;
import model.Product;

import java.util.Date;

/**
 * Created by Andrei_Zanozin on 6/27/2016.
 */
public class AddProductDAOTest {
    public static void main(String[] args) {
        ProductDAO dao = FactoryDAO.getConcreteFactory(0).getProductDAO();

        Product product = new Product();
        product.setSellerLogin("one");
        product.setName("Oven");
        product.setDescription("Microvawe oven");
        product.setPrice(202);
        product.setGap(5);
        product.setHours(6);
        product.setStartBiddingDate(new Date());
        product.setBuyNow(false);

        System.out.println(dao.add(product) + " row(s) insert");
    }
}
