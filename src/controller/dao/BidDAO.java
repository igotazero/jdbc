package controller.dao;

import model.Bid;

public interface BidDAO {
    int add(Bid bid);
    int remove(int id);
    int removeByUser(String userLogin);
    int removeByProduct(int productId);
    Bid getByProduct(int productId);
    Bid getByUser(String userLogin);
    Bid getGreatestByProduct(int productId);
}
