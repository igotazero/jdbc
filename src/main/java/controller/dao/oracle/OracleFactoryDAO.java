package main.java.controller.dao.oracle;

import main.java.controller.dao.BidDAO;
import main.java.controller.dao.FactoryDAO;
import main.java.controller.dao.ProductDAO;
import main.java.controller.dao.UserDAO;

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
}