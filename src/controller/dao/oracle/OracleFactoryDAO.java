package controller.dao.oracle;

import controller.dao.FactoryDAO;
import controller.dao.ProductDAO;
import controller.dao.UserDAO;

public class OracleFactoryDAO extends FactoryDAO {
    @Override
    public ProductDAO getProductDAO(){
        return new OracleProductDAO();
    }
    @Override
    public UserDAO getUserDAO(){
        return new OracleUserDAO();
    }
}