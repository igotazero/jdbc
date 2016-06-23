package controller.dao.oracle;

import controller.dao.FactoryDAO;
import controller.dao.ItemDAO;
import controller.dao.UserDAO;

public class OracleFactoryDAO extends FactoryDAO {
    public ItemDAO getItemDAO(){
        return new OracleItemDAO();
    }
    public UserDAO getUserDAO(){
        return new OracleUserDAO();
    }
}