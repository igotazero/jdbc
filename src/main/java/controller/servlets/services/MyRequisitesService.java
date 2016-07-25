package main.java.controller.servlets.services;

import main.java.controller.servlets.helpers.UserHelper;
import main.java.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Andrei_Zanozin on 7/25/2016.
 */
@Controller
public class MyRequisitesService {
    @RequestMapping(value = "/my_requisites", method = RequestMethod.GET)
    public String myRequisites(ModelMap model) {
        UserHelper userHelper = new UserHelper();
        User user = userHelper.getUserFromSession();
        if (user != null){
            model.addAttribute("login", user.getLogin());
            model.addAttribute("fullName", user.getName());
            model.addAttribute("address", user.getAddress());
        }
        return "my_requisites";
    }
}
