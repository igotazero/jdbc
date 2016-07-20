package main.java.controller.servlets.services;

import main.java.controller.dao.DAOException;
import main.java.controller.dao.FactoryDAO;
import main.java.controller.dao.UserDAO;
import main.java.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by Andrei_Zanozin on 7/20/2016.
 */
@Service
public class UserService {
    private final Logger log = Logger.getLogger(this.getClass());
    private UserDAO dao = FactoryDAO.getConcreteFactory(FactoryDAO.CURRENT_SOURCE).getUserDAO();

    public User getUser(String login){
        User user = null;
        try {
            user = dao.get(login);
        }catch (DAOException e){
            e.printStackTrace();
            toLog(e);
        }
        return user;
    }

    private void toLog(Exception e){
        log.error(e.getMessage() + " // " + Arrays.toString(e.getStackTrace()));
    }
}
