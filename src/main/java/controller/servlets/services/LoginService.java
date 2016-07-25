package main.java.controller.servlets.services;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Andrei_Zanozin on 7/25/2016.
 */
@Controller
public class LoginService {
    @RequestMapping(value = {"/login" }, method = RequestMethod.GET)
    public String login(@RequestParam(value="error", required=false) boolean error, ModelMap model) {
        if (error) {
            model.addAttribute("loginMsg", "Invalid login or password");
        }
        return "login";
    }
}