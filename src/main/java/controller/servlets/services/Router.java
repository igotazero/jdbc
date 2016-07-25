package main.java.controller.servlets.services;

/**
 * Created by Andrei_Zanozin on 7/21/2016.
 */
import main.java.controller.dao.DAOException;
import main.java.controller.servlets.helpers.ProductHelper;
import main.java.controller.servlets.services.UserDetailsServiceImpl;
import main.java.controller.servlets.helpers.UserHelper;
import main.java.model.Product;
import main.java.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class Router {
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcome(@RequestParam(value="error", required=false) boolean error, ModelMap model) {
        if (UserDetailsServiceImpl.getPrincipalName() != null){
            return "user_page";
        }else {
            return "login";
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap model) {
        return "add";
    }

    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public String change(ModelMap model) {
        return "change";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(ModelMap model) {
        return "registration";
    }

}