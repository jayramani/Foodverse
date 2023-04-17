package com.app.foodverse.controllers;

import com.app.foodverse.models.Dishes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class SearchResultController {
    DishesController dishesController = new DishesController();

    @RequestMapping(path = "/search-result", method = RequestMethod.POST)
    public String search(@RequestParam("keyword") String keyword, Model model) throws SQLException {
        List<Dishes> dishes = dishesController.findDishByName(keyword);
        model.addAttribute("dishes",dishes);
        return "/customer/search";
    }
}
