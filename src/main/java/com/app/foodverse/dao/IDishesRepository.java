package com.app.foodverse.dao;

import com.app.foodverse.models.Dishes;

import java.sql.SQLException;
import java.util.List;

public interface IDishesRepository {

    List<Dishes> findDishByName(String keyword) throws SQLException;

    List<Dishes> getAllDishes() throws SQLException;

    List<Dishes> getDishByType(String keyword) throws SQLException;

    List<Dishes> getDishByPrice(int min, int max) throws SQLException;

    List<Dishes> getDishByPriceAndType(String type, int min, int max) throws SQLException;

}
