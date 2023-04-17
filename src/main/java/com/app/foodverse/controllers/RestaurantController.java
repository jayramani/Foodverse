package com.app.foodverse.controllers;

import com.app.foodverse.dao.AddDishRepository;
import com.app.foodverse.models.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Random;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
    AddDishRepository iDishPersistent = new AddDishRepository();

    public static int generateId() {
        int randomId = 0;
        Random rand = new Random();
        for (int j = 0; j < 10; j++) {
            randomId = Math.abs(rand.nextInt());
        }
        return randomId;
    }

    @GetMapping("/")
    public String dish(Model model) {
        Dish dish = new Dish();
        model.addAttribute(dish);
        return "restaurant/addDish";
    }

    @PostMapping("/saveDish")
    public String saveDishes(@ModelAttribute("dish") Dish dish, HttpSession httpSession) throws SQLException {
        dish.setId(generateId());
        boolean result = iDishPersistent.addDish(dish);
        httpSession.setAttribute("success", "Dish Added");
        return "restaurant/addDish";
    }
}