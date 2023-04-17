package com.app.foodverse.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishMapper {
    public static Dish getDish(ResultSet resultSet, Dish dish) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int price = resultSet.getInt("price");
            String type = resultSet.getString("type");
            dish = new Dish(id, name, price, type);
        }
        return dish;
    }
}
