package daoTest;

import controller.dao.FactoryDAO;
import controller.dao.ProductDAO;

/**
 * Created by Andrei_Zanozin on 6/28/2016.
 */
public class delete_user_product_DAO_TEST {
    public static void main(String[] args) {
        ProductDAO dao = FactoryDAO.getConcreteFactory(0).getProductDAO();
        System.out.println(dao.remove(4) + " string(s) removed");
    }
}
