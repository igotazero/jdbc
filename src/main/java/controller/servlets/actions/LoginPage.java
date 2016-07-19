package main.java.controller.servlets.actions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Andrei_Zanozin on 7/18/2016.
 */

@Controller
public class LoginPage {
    @RequestMapping("/login.do")
    public String login(){
        return "redirect:/WEB-INF/login.jsp";
    }
}