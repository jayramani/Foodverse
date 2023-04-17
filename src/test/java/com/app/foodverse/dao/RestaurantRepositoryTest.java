package com.app.foodverse.dao;

import com.app.foodverse.models.Restaurant;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantRepositoryTest implements IRestaurantRepository {

    private final List<Restaurant> restaurantList;
    public List<Restaurant> restaurants = null;

    public int getMockSize() {
        return restaurantList.size();
    }

    public RestaurantRepositoryTest() {
        restaurantList = new ArrayList<>();
        Restaurant r1 = new Restaurant(1, "Bento", "SUB", "NonVeg", "1");
        Restaurant r2 = new Restaurant(2, "Subway", "HSC", "Both", "2");
        Restaurant r3 = new Restaurant(3, "Gnesh Aloopuri", "Surat", "Veg", "3");
        restaurantList.add(r1);
        restaurantList.add(r2);
        restaurantList.add(r3);
    }

    @Override
    public boolean addRestaurant(Restaurant restaurant) throws SQLException {
        return false;
    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) throws SQLException {
        if (restaurantId <= 0 || restaurantId > restaurantList.size()) {
            return null;
        }
        else {
            return restaurantList.get(restaurantId - 1);
        }
    }

    @Override
    public List<Restaurant> getALlRestaurant() throws SQLException {
        restaurants = new ArrayList<>();
        for (Restaurant d : restaurantList) {
            restaurants.add(d);
        }
        return restaurants;
    }
}
