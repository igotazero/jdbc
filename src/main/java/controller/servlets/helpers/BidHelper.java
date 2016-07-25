package main.java.controller.servlets.helpers;

import main.java.controller.dao.BidDAO;
import main.java.controller.dao.DAOException;
import main.java.controller.dao.FactoryDAO;
import main.java.model.Bid;
import main.java.model.Product;
import main.java.model.User;

/**
 * Created by Andrei_Zanozin on 7/26/2016.
 */
public class BidHelper {
    BidDAO dao;
    private final String MUST_BE_GREATER_BI = "Bid must be greater bid inc.";
    private final String MUST_BE_GREATER_SUM = "Bid must be greater then the previous bet amounting to bid inc.";

    public BidHelper(){
        dao = FactoryDAO.getConcreteFactory(FactoryDAO.CURRENT_SOURCE).getBidDAO();
    }

    public String addBid(Product product, User user, double bid) throws DAOException{
        Bid newBid = new Bid(user.getLogin(), product.getId(), bid);
        Bid bestBid = dao.getGreatestByProduct(product.getId());
        double gap = product.getGap();
        if (bestBid == null){
            if (bid >= gap) {
                dao.add(newBid);
                return null;
            }else {
                return MUST_BE_GREATER_BI;
            }
        }else {
            if (bid >= (bestBid.getBid() + gap)){
                dao.add(newBid);
                return null;
            }else {
                return MUST_BE_GREATER_SUM;
            }
        }
    }
}
