package main.java.controller.servlets.services;

import main.java.controller.dao.DAOException;
import main.java.controller.servlets.dto.TableItem;
import main.java.controller.servlets.helpers.BidHelper;
import main.java.controller.servlets.helpers.DealHelper;
import main.java.controller.servlets.helpers.ProductHelper;
import main.java.controller.servlets.helpers.UserHelper;
import main.java.model.Deal;
import main.java.model.Product;
import main.java.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

/**
 * Created by Andrei_Zanozin on 7/25/2016.
 */
@Controller
public class BidService{
    private final String CURRENT_USER_NOT_FOUND = "Current user not found in base";
    private final String PRODUCT_NOT_FOUND = "Product not found in base";
    private final String ADD_IN_CART = "Product has been added to your cart";
    private final String ERROR = "Purchase is failed";
    private final String BID_IS_DONE = "Bid is done!";
    List<TableItem> tableItemList;

    @RequestMapping(value = "/bid.do", method = RequestMethod.POST)
    public String bid(@RequestParam(value="bidButton", required=false) String bidButton,
                      @RequestParam(value="bidValue", required=false) String bidValue, ModelMap model) {
        UserHelper userHelper = new UserHelper();
        User user = userHelper.getUserFromSession();
        try {
            ProductHelper productHelper = new ProductHelper();
            tableItemList = productHelper.getTableItems(productHelper.getAllProducts());
            if (user != null){
                int id = Integer.parseInt(bidButton);
                Product product = productHelper.getProductById(id);
                if (product != null){
                    BidHelper bidHelper = new BidHelper();
                    double bid = Double.parseDouble(bidValue);
                    String message = bidHelper.addBid(product, user, bid);
                    if (message != null){
                        model.addAttribute("bidErr", message);
                    }else {
                        model.addAttribute("bidMsg", BID_IS_DONE);
                    }
                }else {
                    model.addAttribute("bidErr", PRODUCT_NOT_FOUND);
                }
            }else {
                model.addAttribute("bidErr", CURRENT_USER_NOT_FOUND);
            }
            model.addAttribute("tableItemList", tableItemList);
            return "board";
        }catch (DAOException e){
            model.addAttribute("bidErr", e.getMessage());
            model.addAttribute("tableItemList", tableItemList);
            return "board";
        }

    }

    @RequestMapping(value = "/buy.do", method = RequestMethod.POST)
    public String bid(@RequestParam(value="buyButton", required=false) String buyButton, ModelMap model) {
        UserHelper userHelper = new UserHelper();
        try {
            ProductHelper productHelper = new ProductHelper();
            tableItemList = productHelper.getTableItems(productHelper.getAllProducts());
            User user = userHelper.getUserFromSession();
            if (user != null) {
                Product product = productHelper.getProductById(Integer.parseInt(buyButton));
                if (product != null) {
                    Deal deal = new Deal();
                    deal.setProductId(product.getId());
                    deal.setBidPrice(product.getPrice());
                    deal.setSellerId(product.getSellerLogin());
                    deal.setBuyerId(user.getLogin());
                    DealHelper dealHelper = new DealHelper();
                    if (dealHelper.addDeal(deal) > 0){
                        model.addAttribute("bidMsg", ADD_IN_CART);
                    }else {
                        model.addAttribute("bidErr", ERROR);
                    }
                } else {
                    model.addAttribute("bidErr", PRODUCT_NOT_FOUND);
                }
            }else {
                model.addAttribute("bidErr", CURRENT_USER_NOT_FOUND);
            }
            model.addAttribute("tableItemList", tableItemList);
            return "board";
        }catch (DAOException e){
            model.addAttribute("bidErr", e.getMessage());
            model.addAttribute("tableItemList", tableItemList);
            return "board";
        }
    }
}
