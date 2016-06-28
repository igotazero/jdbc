package controller.dao;

import model.Bid;

import java.util.List;

public interface BidDAO {
    int add(Bid bid);
    int remove(int id);
    int removeByUser(String userLogin);
    int removeByProduct(int productId);
    List<Bid> getByProduct(int productId);
    List<Bid> getByUser(String userLogin);
    Bid getGreatestByProduct(int productId);
}
