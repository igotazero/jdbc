package controller.dao.oracle;

import controller.dao.FactoryDAO;
import controller.dao.ItemDAO;
import controller.dao.UserDAO;

public class OracleFactoryDAO extends FactoryDAO {
    public ItemDAO getProductDAO(){
        return new OracleProductDAO();
    }
    public UserDAO getUserDAO(){
        return new OracleUserDAO();
    }
}