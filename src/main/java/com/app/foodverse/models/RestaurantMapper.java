package com.app.foodverse.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantMapper {
    public static Restaurant getRestaurant(ResultSet resultSet, Restaurant restaurant) throws SQLException {
        while (resultSet.next()) {
            int restaurantId = resultSet.getInt("restaurantId");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String type = resultSet.getString("type");
            String userId = resultSet.getString("userId");
            restaurant = new Restaurant(restaurantId, name, address, type, userId);
        }
        return restaurant;
    }
}
