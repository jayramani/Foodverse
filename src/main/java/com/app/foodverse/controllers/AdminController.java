package com.app.foodverse.controllers;

import com.app.foodverse.dao.RestaurantRepository;
import com.app.foodverse.dao.UserRepository;
import com.app.foodverse.models.Restaurant;
import com.app.foodverse.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    Restaurant restaurant = new Restaurant(new RestaurantRepository());

    @GetMapping("/")
    public String getHome() {
        return "/admin/index";
    }

    @GetMapping("/showRequests")
    public String showRequests(Model model) throws SQLException {
        List<Restaurant> restaurants = restaurant.getAllRestaurants();
        model.addAttribute("restaurants", restaurants);
        return "/admin/showRequests";
    }

    @GetMapping("/approveRequest/{id}")
    public String approveRequest(@PathVariable("id") String id) throws SQLException {
        User user = new User(new UserRepository());
        user.approveRestaurant(id);
        return "redirect:{/showRequests}";
    }

}


