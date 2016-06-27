package daoTest;

import controller.dao.FactoryDAO;
import controller.dao.ProductDAO;
import model.Product;

import java.util.Date;

/**
 * Created by Andrei_Zanozin on 6/27/2016.
 */
public class updateProductDAO_Test {
    public static void main(String[] args) {
        ProductDAO dao = FactoryDAO.getConcreteFactory(0).getProductDAO();

        Product product = new Product();
        product.setId(1);
        product.setSellerLogin("one");
        product.setName("hui");
        product.setDescription("Cell phone");
        product.setPrice(2000);
        product.setGap(8);
        product.setHours(12);
        product.setStartBiddingDate(new Date());
        product.setBuyNow(false);

        System.out.println(dao.update(product) + " row(s) update");
    }
}
