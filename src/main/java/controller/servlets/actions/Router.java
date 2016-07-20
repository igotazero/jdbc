package main.java.controller.servlets.actions;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Andrei_Zanozin on 7/19/2016.
 */
@Controller
public class Router {
    @RequestMapping("/add.htm")
    public String add(){
        return "forward:/WEB-INF/jsp/add.jsp";
    }
    @RequestMapping("/board.htm")
    public String board(){
        return "forward:/WEB-INF/jsp/board.jsp";
    }
    @RequestMapping("/change.htm")
    public String change(){
        return "forward:/WEB-INF/jsp/change.jsp";
    }
    @RequestMapping("/login.htm")
    public String login(){
        return "forward:/WEB-INF/jsp/login.jsp";
    }
    @RequestMapping("/my_requisites.htm")
    public String myRequisites(){
        return "forward:/WEB-INF/jsp/my_requisites.jsp";
    }
    @RequestMapping("/registration.htm")
    public String registration(){
        return "forward:/WEB-INF/jsp/registration.jsp";
    }
    @RequestMapping("/user_page.htm")
    public String userPage(){
        return "forward:/WEB-INF/jsp/user_page.jsp";
    }
}