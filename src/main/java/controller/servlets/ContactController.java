package main.java.controller.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    @RequestMapping("/registration")
    public String registrationPage(){
        return "redirect:/registration";
    }
}
