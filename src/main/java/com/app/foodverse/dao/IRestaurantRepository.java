package com.app.foodverse.dao;

import com.app.foodverse.models.Restaurant;

import java.sql.SQLException;
import java.util.List;

public interface IRestaurantRepository {

    boolean addRestaurant(Restaurant restaurant) throws SQLException;

    Restaurant getRestaurantById(int restaurantId) throws SQLException;

    public List<Restaurant> getALlRestaurant() throws SQLException;

}
