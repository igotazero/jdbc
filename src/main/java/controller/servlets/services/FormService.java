package main.java.controller.servlets.services;

import main.java.controller.dao.DAOException;
import main.java.controller.servlets.helpers.UserHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Andrei_Zanozin on 7/24/2016.
 */
@Controller
public class FormService {
    @RequestMapping(value = "/registration.form", method = RequestMethod.POST)
    public String registrationForm(HttpServletRequest request, HttpServletResponse response, ModelMap model)
    {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String name = request.getParameter("full_name");
        String address = request.getParameter("address");
        UserHelper userHelper = new UserHelper();
        try {
            if (userHelper.addUserToDB(login, password, name, address) > 0) {
                model.addAttribute("loginMsg", "Registration completed successfully. Please, login");
                return "login";
            } else {
                model.addAttribute("regMsg", "Registration error");
                return "registration";
            }
        }catch (DAOException e){
            model.addAttribute("regMsg", e.getMessage());
            model.addAttribute("passwordOnRefresh", password);
            model.addAttribute("nameOnRefresh", name);
            model.addAttribute("addressOnRefresh", address);
            return "registration";
        }
    }
}