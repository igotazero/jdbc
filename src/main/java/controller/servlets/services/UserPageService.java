package main.java.controller.servlets.services;

import main.java.controller.dao.DAOException;
import main.java.controller.servlets.dto.CardItem;
import main.java.controller.servlets.dto.TableItem;
import main.java.controller.servlets.helpers.DealHelper;
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
public class UserPageService{
    private final String NO_USERS_PRODUCTS = "You have not added any product";
    private final String NO_PRODUCTS_IN_CART = "No products in the cart.";

    @RequestMapping(value = "/user_page", method = RequestMethod.GET)
    public String userPage(ModelMap model) {
        try {
            ProductHelper productHelper = new ProductHelper();
            String login = UserDetailsServiceImpl.getPrincipalName();
            if (login != null) {
                List<TableItem> tableItemList = productHelper.getTableItems(productHelper.getUsersProducts(login));
                if (!tableItemList.isEmpty()) {
                    model.addAttribute("tableItemList", tableItemList);
                } else {
                    model.addAttribute("upMsg", NO_USERS_PRODUCTS);
                }
            }
            DealHelper dealHelper = new DealHelper();
            List<CardItem> cardItemList = dealHelper.getCardItems(dealHelper.getDealingsByUser(login));
            if (!cardItemList.isEmpty()){
                model.addAttribute("cartItemList", cardItemList);
            }else {
                model.addAttribute("upMsgDeals", NO_PRODUCTS_IN_CART);
            }
            return "user_page";
        }catch (DAOException e){
            model.addAttribute("bidErr", e.getMessage());
            return "user_page";
        }
    }
}
