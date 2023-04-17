package com.app.foodverse.models;

import com.app.foodverse.dao.IDishesRepository;

import java.sql.SQLException;
import java.util.List;

public class Dishes {

    private IDishesRepository dishesRepository = null;
    private int dishId;
    private String dishName;
    private int dishPrice;
    private String dishType;

    public void setDishId(int dishId) {
        if (dishId <= 0) {
            return;
        }
        this.dishId = dishId;
    }

    public void setDishName(String dishName) {
        if (dishName.equals("")) {
            return;
        }
        this.dishName = dishName;
    }

    public void setDishPrice(int dishPrice) {
        if (dishPrice <= 0) {
            return;
        }
        this.dishPrice = dishPrice;
    }

    public void setDishType(String dishType) {
        if (dishType.equals("")) {
            return;
        }
        this.dishType = dishType;
    }

    public int getDishId() {
        return dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public int getDishPrice() {
        return dishPrice;
    }

    public String getDishType() {
        return dishType;
    }

    public Dishes(int dishId, String dishName, int dishPrice, String dishType) {
        this.dishId = dishId;
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.dishType = dishType;
    }

    public Dishes(IDishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
    }

    public List<Dishes> findDishByName(String keyword) throws SQLException {
        List<Dishes> dishes = this.dishesRepository.findDishByName(keyword);
        return dishes;
    }

    public List<Dishes> getAllDishes() throws SQLException {
        List<Dishes> dishes = this.dishesRepository.getAllDishes();
        return dishes;
    }

    public List<Dishes> getDishByType(String keyword) throws SQLException {
        List<Dishes> dishes = this.dishesRepository.getDishByType(keyword);
        return dishes;
    }

    public List<Dishes> getDishByPrice(int min, int max) throws SQLException {
        List<Dishes> dishes = this.dishesRepository.getDishByPrice(min, max);
        return dishes;
    }

    public List<Dishes> getDishByPriceAndType(String type, int min, int max) throws SQLException {
        List<Dishes> dishes = this.dishesRepository.getDishByPriceAndType(type, min, max);
        return dishes;
    }

}
