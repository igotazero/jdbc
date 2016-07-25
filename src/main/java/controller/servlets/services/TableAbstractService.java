package main.java.controller.servlets.services;

import main.java.controller.dao.DAOException;
import main.java.controller.servlets.dto.TableItem;
import main.java.controller.servlets.helpers.ProductHelper;
import main.java.model.Product;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by Andrei_Zanozin on 7/25/2016.
 */
public abstract class TableAbstractService {
    protected void fillModelTable(ModelMap model){
        try {
            ProductHelper productHelper = new ProductHelper();
            List<TableItem> tableItemList = productHelper.getTableItems(productHelper.getAllProducts());
            if (!tableItemList.isEmpty()){
                model.addAttribute("tableItemList", tableItemList);
            }else {
                model.addAttribute("tableErr", "No products in base");
            }
        }catch (DAOException e){
            model.addAttribute("tableErr", e.getMessage());
        }
    }
}
