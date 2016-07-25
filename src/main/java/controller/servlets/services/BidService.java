package main.java.controller.servlets.services;

import main.java.controller.dao.DAOException;
import main.java.controller.servlets.helpers.BidHelper;
import main.java.controller.servlets.helpers.ProductHelper;
import main.java.controller.servlets.helpers.UserHelper;
import main.java.model.Product;
import main.java.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Andrei_Zanozin on 7/25/2016.
 */
@Controller
public class BidService extends TableAbstractService {
    @RequestMapping(value = "/bid.do", method = RequestMethod.POST)
    public String bid(@RequestParam(value="bidButton", required=false) String bidButton,
                      @RequestParam(value="bidValue", required=false) String bidValue, ModelMap model) {
        UserHelper userHelper = new UserHelper();
        User user = userHelper.getUserFromSession();
        try {
            if (user != null){
                ProductHelper productHelper = new ProductHelper();
                int id = Integer.parseInt(bidButton);
                Product product = productHelper.getProductById(id);
                if (product != null){
                    BidHelper bidHelper = new BidHelper();
                    double bid = Double.parseDouble(bidValue);
                    String message = bidHelper.addBid(product, user, bid);
                    if (message != null){
                        model.addAttribute("bidErr", message);
                        fillModelTable(model);
                        return "board";
                    }
                }else {
                    model.addAttribute("bidErr", "Current user not found in base");
                    fillModelTable(model);
                    return "board";
                }
            }else {
                model.addAttribute("bidErr", "Current user not found in base");
                fillModelTable(model);
                return "board";
            }
        }catch (DAOException e){
            model.addAttribute("bidErr", e.getMessage());
            fillModelTable(model);
            return "board";
        }
        fillModelTable(model);
        return "board";
    }
}
