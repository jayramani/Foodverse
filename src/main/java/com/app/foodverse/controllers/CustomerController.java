package com.app.foodverse.controllers;

import com.app.foodverse.models.Dishes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

import static java.lang.Integer.parseInt;

@Controller
public class CustomerController {
    DishesController dishesController = new DishesController();

    @GetMapping("/customer")
    public String dishes(Model model) throws SQLException {
        List<Dishes> dishes = dishesController.getAllDishes();
        model.addAttribute("dishes", dishes);
        return "customer/index";
    }

    @RequestMapping(path = "/filter-food", method = RequestMethod.POST)
    public String filterByType(@RequestParam("keyword") String keyword, @RequestParam("min") String min,
                               @RequestParam("max") String max, Model model) throws SQLException {
        List<Dishes> dishes = null;
        if (!keyword.equals("") && (!min.equals("") && !max.equals(""))) {
            dishes = dishesController.getDishByPriceAndType(keyword, parseInt(min), parseInt(max));
        }
        else if (min.equals("") && max.equals("")) {
            dishes = dishesController.getDishByType(keyword);
        }
        else if (keyword.equals("") && (!min.equals("") && !max.equals(""))) {
            dishes = dishesController.getDishByPrice(parseInt(min), parseInt(max));
        }
        else {
            dishes = dishesController.getAllDishes();
        }
        model.addAttribute("dishes", dishes);
        return "customer/index";
    }

}
