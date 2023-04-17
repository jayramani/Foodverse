package com.app.foodverse.dao;

import com.app.foodverse.models.Dishes;

import java.sql.SQLException;

public interface ICartRepository {

    Dishes getDishById(int id) throws SQLException;

}
