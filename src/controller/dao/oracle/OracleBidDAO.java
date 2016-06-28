package controller.dao.oracle;

import controller.dao.BidDAO;
import controller.dao.FactoryDAO;
import model.Bid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/28/2016.
 */
public class OracleBidDAO implements BidDAO{
    private final String TABLE_NAME = "Bids";
    private final String ID = "ID";
    private final String USER = "USERLOGIN";
    private final String PRODUCT = "PRODUCTID";
    private final String BID = "BID";
    private final Executor<Bid> executor = new Executor<>();

    @Override
    public int add(Bid bid) {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO ").append(TABLE_NAME).append(" (")
                .append(ID).append(", ")
                .append(USER).append(", ")
                .append(PRODUCT).append(", ")
                .append(BID).append(") VALUES (bids_seq.nextval, ?, ?, ?)");

        List<String> args = new ArrayList<>();
        args.add(bid.getUserLogin());
        args.add(Integer.toString(bid.getProductId()));
        args.add(Double.toString(bid.getBid()));
        return executor.execUpdate(query.toString(), args);
    }

    @Override
    public Bid getByProduct(int productId) {
        return null;
    }

    @Override
    public Bid getByUser(String userLogin) {
        return null;
    }

    @Override
    public int remove(int id) {
        return 0;
    }

    @Override
    public int removeByUser(String userLogin) {
        return 0;
    }

    @Override
    public int removeByProduct(int productId) {
        return 0;
    }

    @Override
    public Bid getGreatestByProduct(int productId) {
        return null;
    }
}
