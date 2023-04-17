package com.app.foodverse.dao;

import com.app.foodverse.models.Restaurant;
import com.app.foodverse.models.RestaurantMapper;
import com.mysql.cj.jdbc.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository implements IRestaurantRepository {

    List<Restaurant> restaurantList = new ArrayList<>();

    @Override
    public boolean addRestaurant(Restaurant restaurant) throws SQLException {
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall("{call saveRestaurant(?,?,?,?,?)}").unwrap(CallableStatement.class);
            statement.setInt(1, restaurant.getRestaurantId());
            statement.setString(2, restaurant.getName());
            statement.setString(3, restaurant.getAddress());
            statement.setString(4, restaurant.getType());
            statement.setString(5, restaurant.getCurrentUser());
            boolean getResult = statement.execute();
            return getResult;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            statement.close();
            connection.close();
        }
    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) throws SQLException {
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        Restaurant restaurant = null;
        try {
            statement = connection.prepareCall("{call getRestaurantById(?)}").unwrap(CallableStatement.class);
            statement.setInt(1, restaurantId);
            boolean getResult = statement.execute();
            while (getResult) {
                ResultSet resultSet = statement.getResultSet();
                restaurant = RestaurantMapper.getRestaurant(resultSet, restaurant);
                getResult = statement.getMoreResults();
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            statement.close();
            connection.close();
        }
        return restaurant;
    }

    @Override
    public List<Restaurant> getALlRestaurant() throws SQLException {
        restaurantList.clear();
        Restaurant restaurant = null;
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall("{call getAllRestaurant()}").unwrap(CallableStatement.class);
            boolean getResult = statement.execute();
            while (getResult) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    int restaurantId = rs.getInt("restaurantId");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    String type = rs.getString("type");
                    String userId = rs.getString("userId");
                    restaurant = new Restaurant(restaurantId, name, address, type, userId);
                    restaurantList.add(restaurant);
                }
                getResult = statement.getMoreResults();
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            statement.close();
            connection.close();
        }
        return restaurantList;
    }
}
