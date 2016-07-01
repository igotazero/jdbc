package main.java.controller.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 6/23/2016.
 */
public interface ResultHandler<T> {
    List<T> convert(ResultSet resultSet) throws DAOException;
}
