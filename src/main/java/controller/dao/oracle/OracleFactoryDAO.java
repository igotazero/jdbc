package main.java.controller.dao.oracle;

import main.java.controller.dao.*;

public class OracleFactoryDAO extends FactoryDAO {
    @Override
    public ProductDAO getProductDAO(){
        return new OracleProductDAO();
    }
    @Override
    public UserDAO getUserDAO(){
        return new OracleUserDAO();
    }
    @Override
    public BidDAO getBidDAO() {
        return new OracleBidDAO();
    }
    @Override
    public DealDAO getDealDAO() {
        return new OracleDealDAO();
    }
}