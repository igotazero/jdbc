package controller.dao;

import controller.dao.oracle.OracleFactoryDAO;

public abstract class FactoryDAO {
    public static final int ORACLE = 0;

    public static FactoryDAO getConcreteFactory(int type){
        switch (type){
            case ORACLE:{
                return new OracleFactoryDAO();
            }
            default:return null;
        }
    }
}
