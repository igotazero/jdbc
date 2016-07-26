package main.java.controller.servlets.helpers;

import main.java.controller.dao.DAOException;
import main.java.controller.dao.DealDAO;
import main.java.controller.dao.FactoryDAO;
import main.java.controller.dao.oracle.ParseHandler;
import main.java.controller.servlets.dto.CardItem;
import main.java.model.Deal;
import main.java.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 7/26/2016.
 */
public class DealHelper {
    private DealDAO dao;

    public DealHelper(){
        dao = FactoryDAO.getConcreteFactory(FactoryDAO.CURRENT_SOURCE).getDealDAO();
    }

    public int addDeal(Deal deal) throws DAOException{
        return dao.add(deal);
    }

    public Deal getDeal(int productId) throws DAOException{
        return dao.get(productId);
    }

    public List<Deal> getDealingsByUser(String userLogin) throws DAOException{
        return dao.getDealingsByUser(userLogin);
    }

    public List<CardItem> getCardItems(List<Deal> list) throws DAOException{
        List<CardItem> res = new ArrayList<>();
        for (Deal d : list) {
            CardItem cardItem = new CardItem();
            ProductHelper productHelper = new ProductHelper();
            Product product = productHelper.getProductById(d.getProductId());
            cardItem.setProductId(Integer.toString(product.getId()));
            cardItem.setTitle(product.getName());
            cardItem.setDescription(product.getDescription());
            cardItem.setBidPrice(Double.toString(d.getBidPrice()));
            cardItem.setSeller(d.getSellerId());
            cardItem.setDealTime(ParseHandler.dateToString(d.getDealDate()));
            res.add(cardItem);
        }
        return res;
    }
}
