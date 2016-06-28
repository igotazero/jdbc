package daoTest.user;

import controller.dao.FactoryDAO;
import controller.dao.UserDAO;
import model.User;

/**
 * Created by Andrei_Zanozin on 6/28/2016.
 */
public class UserDAO_TEST {
    public static void main(String[] args) {
        addUser_TEST();
        //getUser_TEST();
        //updateUser_TEST();
        //removeUser_TEST();
    }

    private static void addUser_TEST(){
        UserDAO dao = FactoryDAO.getConcreteFactory(0).getUserDAO();

        User user = new User();
        user.setLogin("koshi");
        user.setPassword("753159");
        user.setName("Koshi");
        user.setAddress("London");

        System.out.println(dao.add(user) + " row(s) added");
    }

    private static void getUser_TEST(){
        UserDAO dao = FactoryDAO.getConcreteFactory(0).getUserDAO();

        System.out.println(dao.get("koshi"));
    }


    private static void updateUser_TEST(){
        UserDAO dao = FactoryDAO.getConcreteFactory(0).getUserDAO();

        User user = new User();
        user.setLogin("puankre");
        user.setPassword("753159");
        user.setName("Puankre");
        user.setAddress("Saratov");

        System.out.println(dao.update(user) + " row(s) is updated");
    }

    private static void removeUser_TEST(){
        UserDAO dao = FactoryDAO.getConcreteFactory(0).getUserDAO();

        System.out.println(dao.remove("koshi") + " row(s) removed");
    }

}
