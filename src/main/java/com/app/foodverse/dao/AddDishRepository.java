package com.app.foodverse.dao;

import com.app.foodverse.models.Dish;
import com.app.foodverse.models.DishMapper;
import com.mysql.cj.jdbc.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddDishRepository implements IAddDishRepository {
    @Override
    public boolean addDish(Dish dish) throws SQLException {
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall("{call saveDishes(?,?,?,?)}").unwrap(CallableStatement.class);
            statement.setInt(1, dish.getId());
            statement.setString(2,dish.getName());
            statement.setInt(3,dish.getPrice());
            statement.setString(4,dish.getType());
            boolean getResult = statement.execute();
            return getResult;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            statement.close();
            connection.close();
        }
    }

    @Override
    public Dish getDishById(int id) throws SQLException {
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        Dish dish = null;
        try {
            statement = connection.prepareCall("{call getDishById(?)}").unwrap(CallableStatement.class);
            statement.setInt(1, id);
            boolean getResult = statement.execute();
            while (getResult) {
                ResultSet resultSet = statement.getResultSet();
                dish = DishMapper.getDish(resultSet, dish);
                getResult = statement.getMoreResults();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            statement.close();
            connection.close();
        }
        return dish;
    }
}