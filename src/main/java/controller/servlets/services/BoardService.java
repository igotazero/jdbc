package main.java.controller.servlets.services;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Andrei_Zanozin on 7/25/2016.
 */
@Controller
public class BoardService extends TableAbstractService {
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String board(ModelMap model) {
        fillModelTable(model);
        return "board";
    }
}