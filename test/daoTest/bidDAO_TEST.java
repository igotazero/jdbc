package daoTest;

import controller.dao.BidDAO;
import controller.dao.FactoryDAO;
import model.Bid;

/**
 * Created by Andrei_Zanozin on 6/28/2016.
 */
public class bidDAO_TEST {
    public static void main(String[] args) {
        addBid_TEST();
    }

    private static void addBid_TEST(){
        BidDAO dao = FactoryDAO.getConcreteFactory(0).getBidDAO();

        Bid bid = new Bid();
        bid.setUserLogin("koshi");
        bid.setProductId(3);
        bid.setBid(300);

        System.out.println(dao.add(bid) + " row(s) added");
    }
}
