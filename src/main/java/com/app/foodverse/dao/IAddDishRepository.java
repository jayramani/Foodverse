package com.app.foodverse.dao;

import com.app.foodverse.models.Dish;

import java.sql.SQLException;

public interface IAddDishRepository {
    boolean addDish(Dish dish) throws SQLException;

    Dish getDishById(int id) throws SQLException;
}