package com.app.foodverse.controllers;

import com.app.foodverse.dao.DishesRepository;
import com.app.foodverse.models.Dishes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class DishesController {

    Dishes dishes = new Dishes(new DishesRepository());

    @GetMapping("/api/search-result/{keyword}")
    public List<Dishes> findDishByName(@PathVariable("keyword") String keyword) throws SQLException {
        return dishes.findDishByName(keyword);
    }

    @GetMapping("/api/index")
    public List<Dishes> getAllDishes() throws SQLException {
        return dishes.getAllDishes();
    }

    @GetMapping("/api/filter-food/{keyword}")
    public List<Dishes> getDishByType(@PathVariable("keyword") String keyword) throws SQLException {
        return dishes.getDishByType(keyword);
    }

    @GetMapping("/api/filter-food/{min}/{max}")
    public List<Dishes> getDishByPrice(@PathVariable("min") int min, @PathVariable("max") int max) throws SQLException {
        return dishes.getDishByPrice(min, max);
    }

    @GetMapping("/api/filter-food/{keyword}/{min}/{max}")
    public List<Dishes> getDishByPriceAndType(@PathVariable("keyword") String keyword, @PathVariable("min") int min,
                                              @PathVariable("max") int max) throws SQLException {
        return dishes.getDishByPriceAndType(keyword, min, max);
    }

}
