package com.app.foodverse.controllers;

import com.app.foodverse.dao.RestaurantRepository;
import com.app.foodverse.models.Restaurant;
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
@RequestMapping("/request")
public class RestaurantRequestController {
    RestaurantRepository restaurantRepository = new RestaurantRepository();

    public static int generateId() {
        int randomId = 0;
        Random rand = new Random();
        for (int j = 0; j < 10; j++) {
            randomId = Math.abs(rand.nextInt());
        }
        return randomId;
    }

    @GetMapping("/")
    public String restaurant(Model model) {
        Restaurant restaurant = new Restaurant();
        model.addAttribute(restaurant);
        return "request/addRestaurant";
    }

    @PostMapping("/addRestaurant")
    public String saveRestaurant(@ModelAttribute("restaurant") Restaurant restaurant, HttpSession httpSession) throws SQLException {
        restaurant.setRestaurantId(generateId());
        boolean result = restaurantRepository.addRestaurant(restaurant);
        httpSession.setAttribute("success", "restaurant Registered");
        System.out.println(result);
        return "request/index";
    }
}