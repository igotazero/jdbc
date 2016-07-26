package main.java.controller.servlets.helpers;

import main.java.controller.dao.BidDAO;
import main.java.controller.dao.DAOException;
import main.java.controller.dao.FactoryDAO;
import main.java.controller.dao.ProductDAO;
import main.java.controller.dao.oracle.ParseHandler;
import main.java.controller.servlets.dto.CardItem;
import main.java.controller.servlets.dto.TableItem;
import main.java.model.Bid;
import main.java.model.Deal;
import main.java.model.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 7/25/2016.
 */

public class ProductHelper {
    ProductDAO dao;

    public ProductHelper(){
        dao = FactoryDAO.getConcreteFactory(FactoryDAO.CURRENT_SOURCE).getProductDAO();
    }

    public List<Product> getAllProducts() throws DAOException{
        return dao.getAll();
    }

    public Product getProductById(int id) throws DAOException{
        return dao.get(id);
    }

    public List<Product> getUsersProducts(String userLogin) throws DAOException{
        return dao.getProductsByUser(userLogin);
    }

    public List<TableItem> getTableItems(List<Product> list) throws DAOException{
        List<TableItem> res = new ArrayList<>();
        for(Product p : list){
            TableItem tableItem = new TableItem();
            tableItem.setId(Integer.toString(p.getId()));
            tableItem.setTitle(p.getName());
            tableItem.setDescription(p.getDescription());
            tableItem.setPrice(Double.toString(p.getPrice()));
            tableItem.setBidInc(Double.toString(p.getGap()));
            BidDAO bidDAO = FactoryDAO.getConcreteFactory(FactoryDAO.CURRENT_SOURCE).getBidDAO();
            Bid bestBid = bidDAO.getGreatestByProduct(p.getId());
            if (bestBid != null){
                tableItem.setBestOffer(Double.toString(bestBid.getBid()));
                tableItem.setBidder(bestBid.getUserLogin());
            }else {
                tableItem.setBestOffer("-");
                tableItem.setBidder("-");
            }
            Date date = new Date(p.getStartBiddingDate().getTime() + (p.getHours() * 3600000));
            tableItem.setStopDate(ParseHandler.dateToString(date));
            boolean isBuyNow = p.isBuyNow();
            if (isBuyNow){
                tableItem.setBuyNow("1");
            }else {
                tableItem.setBuyNow("0");
            }
            tableItem.setSellerLogin(p.getSellerLogin());
            DealHelper dealHelper = new DealHelper();
            Deal deal = dealHelper.getDeal(p.getId());
            if (deal != null){
                tableItem.setInCart("1");
                if (isBuyNow){
                    tableItem.setBidder(deal.getBuyerId());
                }
            }else {
                tableItem.setInCart("0");
            }
            res.add(tableItem);
        }
        return res;
    }
}
