package com.app.foodverse.dao;

import com.app.foodverse.models.Dishes;
import com.mysql.cj.jdbc.CallableStatement;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CartRepository implements ICartRepository {
    public Dishes getDishById(int id) throws SQLException {
        Dishes dishes = null;
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall("{call getDishById(?)}").unwrap(CallableStatement.class);
            statement.setInt(1, id);
            boolean getResult = statement.execute();
            while (getResult) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    int dishId = rs.getInt("id");
                    String dishName = rs.getString("name");
                    int dishPrice = rs.getInt("price");
                    String dishType = rs.getString("type");
                    dishes = new Dishes(dishId, dishName, dishPrice, dishType);
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
        return dishes;
    }
}