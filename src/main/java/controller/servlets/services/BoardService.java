package main.java.controller.servlets.services;

import main.java.controller.dao.DAOException;
import main.java.controller.servlets.dto.TableItem;
import main.java.controller.servlets.helpers.ProductHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Andrei_Zanozin on 7/25/2016.
 */
@Controller
public class BoardService {
    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String board(ModelMap model) {
        try {
            ProductHelper productHelper = new ProductHelper();
            List<TableItem> tableItemList = productHelper.getTableItems(productHelper.getAllProducts());
            model.addAttribute("tableItemList", tableItemList);
            return "board";
        }catch (DAOException e){
            model.addAttribute("bidErr", e.getMessage());
            return "board";
        }
    }
}