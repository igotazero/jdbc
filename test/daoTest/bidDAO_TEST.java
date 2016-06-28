package daoTest;

import controller.dao.BidDAO;
import controller.dao.FactoryDAO;
import model.Bid;

/**
 * Created by Andrei_Zanozin on 6/28/2016.
 */
public class bidDAO_TEST {
    public static void main(String[] args) {
        //addBid_TEST();
        //getByProduct_TEST();
        //getByUser_TEST();
        //removeFromID_TEST();
        //removeByUser_TEST();
        //removeByProduct_TEST();
        getGreatestByProduct_TEST();
    }

    private static void addBid_TEST(){
        BidDAO dao = FactoryDAO.getConcreteFactory(0).getBidDAO();

        Bid bid = new Bid();
        bid.setUserLogin("koshi");
        bid.setProductId(3);
        bid.setBid(400);

        System.out.println(dao.add(bid) + " row(s) added");
    }

    private static void getByProduct_TEST(){
        BidDAO dao = FactoryDAO.getConcreteFactory(0).getBidDAO();
        for(Bid b : dao.getByProduct(7)){
            System.out.println(b.toString());
        }
    }

    private static void getByUser_TEST(){
        BidDAO dao = FactoryDAO.getConcreteFactory(0).getBidDAO();
        for(Bid b : dao.getByUser("koshi")){
            System.out.println(b.toString());
        }
    }

    private static void removeFromID_TEST(){
        BidDAO dao = FactoryDAO.getConcreteFactory(0).getBidDAO();
        System.out.println(dao.remove(2) + " row(s) removed");
    }

    private static void removeByUser_TEST(){
        BidDAO dao = FactoryDAO.getConcreteFactory(0).getBidDAO();
        System.out.println(dao.removeByUser("koshi") + " row(s) removed");
    }

    private static void removeByProduct_TEST(){
        BidDAO dao = FactoryDAO.getConcreteFactory(0).getBidDAO();
        System.out.println(dao.removeByProduct(3) + " row(s) removed");
    }

    private static void getGreatestByProduct_TEST(){
        BidDAO dao = FactoryDAO.getConcreteFactory(0).getBidDAO();
        System.out.println(dao.getGreatestByProduct(3));
    }
}
