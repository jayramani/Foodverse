package com.app.foodverse.dao;

import com.app.foodverse.models.Dishes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishesRepositoryTest implements IDishesRepository {

    public List<Dishes> dishesList;

    public DishesRepositoryTest() {
        dishesList = new ArrayList<>();
        Dishes d1 = new Dishes(1, "Paneer Sandwich", 8, "Veg");
        Dishes d2 = new Dishes(2, "Biryani", 11, "Veg");
        Dishes d3 = new Dishes(3, "Chicken Tikka", 7, "Nonveg");
        Dishes d4 = new Dishes(4, "Nonveg Combo", 9, "Nonveg");
        dishesList.add(d1);
        dishesList.add(d2);
        dishesList.add(d3);
        dishesList.add(d4);
    }

    @Override
    public List<Dishes> findDishByName(String keyword) {
        List<Dishes> dishes = new ArrayList<>();
        for (Dishes d : dishesList) {
            if (d.getDishName().contains(keyword)) {
                dishes.add(d);
            }
        }
        return dishes;
    }

    @Override
    public List<Dishes> getAllDishes() {
        List<Dishes> dishes = new ArrayList<>();
        for (Dishes d : dishesList) {
            dishes.add(d);
        }
        return dishes;
    }

    @Override
    public List<Dishes> getDishByType(String keyword) {
        List<Dishes> dishes = new ArrayList<>();
        for (Dishes d : dishesList) {
            if (d.getDishType().equalsIgnoreCase(keyword)) {
                dishes.add(d);
            }
        }
        return dishes;
    }

    @Override
    public List<Dishes> getDishByPrice(int min, int max) {
        List<Dishes> dishes = new ArrayList<>();
        if (min > max) {
            return dishes;
        }
        else if (min == max) {
            for (Dishes d : dishesList) {
                if (d.getDishPrice() == min) {
                    dishes.add(d);
                }
            }
        }
        else {
            for (Dishes d : dishesList) {
                if (d.getDishPrice() >= min && d.getDishPrice() <= max) {
                    dishes.add(d);
                }
            }
        }
        return dishes;
    }

    @Override
    public List<Dishes> getDishByPriceAndType(String type, int min, int max) throws SQLException {
        List<Dishes> dishes = new ArrayList<>();
        if (!type.equals("") && (min != 0 && max != 0)) {
            for (Dishes d : dishesList) {
                if (d.getDishType().equals(type) && d.getDishPrice() > min && d.getDishPrice() < max) {
                    dishes.add(d);
                }
            }
        }
        else if (min == 0 && max == 0) {
            for (Dishes d : dishesList) {
                if (d.getDishType().equals(type)) {
                    dishes.add(d);
                }
            }
        }
        else if (type.equals("") && (min != 0 && max != 0)) {
            for (Dishes d : dishesList) {
                if (d.getDishPrice() > min && d.getDishPrice() < max) {
                    dishes.add(d);
                }
            }
        }
        else {
            dishes = dishesList;
        }
        return dishes;
    }
}
