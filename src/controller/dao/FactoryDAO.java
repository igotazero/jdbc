package controller.dao;

import controller.dao.oracle.OracleFactoryDAO;

public abstract class FactoryDAO {
    public static final int ORACLE = 0;

    public abstract ProductDAO getProductDAO();
    public abstract UserDAO getUserDAO();
    public abstract BidDAO getBidDAO();

    public static FactoryDAO getConcreteFactory(int type){
        switch (type){
            case ORACLE:{
                return new OracleFactoryDAO();
            }
            default:return null;
        }
    }
}
