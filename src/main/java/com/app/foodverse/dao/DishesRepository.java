package com.app.foodverse.dao;

import com.app.foodverse.models.Dishes;
import com.mysql.cj.jdbc.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishesRepository implements IDishesRepository {

    List<Dishes> searchResult = new ArrayList<>();
    List<Dishes> byTypeResult = new ArrayList<>();
    List<Dishes> byPriceResult = new ArrayList<>();
    List<Dishes> byPriceAndTypeResult = new ArrayList<>();


    @Override
    public List<Dishes> findDishByName(String keyword) throws SQLException {
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        Dishes dishes = null;
        searchResult.clear();
        try {
            statement = connection.prepareCall("{call findByKeyWord(?)}").unwrap(CallableStatement.class);
            statement.setString(1, keyword);
            boolean getResult = statement.execute();
            while (getResult) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    int dishId = rs.getInt("id");
                    String dishName = rs.getString("name");
                    int dishPrice = rs.getInt("price");
                    String dishType = rs.getString("type");
                    dishes = new Dishes(dishId, dishName, dishPrice, dishType);
                    searchResult.add(dishes);
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
        return searchResult;
    }

    @Override
    public List<Dishes> getAllDishes() throws SQLException {
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        List<Dishes> dishesList = new ArrayList<>();
        Dishes dishes = null;
        try {
            statement = connection.prepareCall("{call getAllDishes()}").unwrap(CallableStatement.class);

            boolean getResult = statement.execute();

            while (getResult) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    int dishId = rs.getInt("id");
                    String dishName = rs.getString("name");
                    int dishPrice = rs.getInt("price");
                    String dishType = rs.getString("type");

                    dishes = new Dishes(dishId, dishName, dishPrice, dishType);
                    dishesList.add(dishes);
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
        return dishesList;
    }

    public List<Dishes> getDishByType(String keyword) throws SQLException {
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        Dishes dishes = null;
        byTypeResult.clear();
        try {
            statement = connection.prepareCall("{call getDishByType(?)}").unwrap(CallableStatement.class);
            statement.setString(1, keyword);
            boolean getResult = statement.execute();
            while (getResult) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    int dishId = rs.getInt("id");
                    String dishName = rs.getString("name");
                    int dishPrice = rs.getInt("price");
                    String dishType = rs.getString("type");
                    dishes = new Dishes(dishId, dishName, dishPrice, dishType);
                    byTypeResult.add(dishes);
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
        return byTypeResult;
    }

    @Override
    public List<Dishes> getDishByPrice(int min, int max) throws SQLException {
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        Dishes dishes = null;
        byPriceResult.clear();
        try {
            statement = connection.prepareCall("{call getDishByPrice(?,?)}").unwrap(CallableStatement.class);
            statement.setInt(1, min);
            statement.setInt(2, max);
            boolean getResult = statement.execute();
            while (getResult) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    int dishId = rs.getInt("id");
                    String dishName = rs.getString("name");
                    int dishPrice = rs.getInt("price");
                    String dishType = rs.getString("type");
                    dishes = new Dishes(dishId, dishName, dishPrice, dishType);
                    byPriceResult.add(dishes);
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
        return byPriceResult;
    }

    @Override
    public List<Dishes> getDishByPriceAndType(String type,int min, int max) throws SQLException {
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        Dishes dishes = null;
        byPriceAndTypeResult.clear();
        try {
            statement = connection.prepareCall("{call getDishesByTypeAndPrice(?,?,?)}").unwrap(CallableStatement.class);
            statement.setString(1,type);
            statement.setInt(2, min);
            statement.setInt(3, max);
            boolean getResult = statement.execute();
            while (getResult) {
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    int dishId = rs.getInt("id");
                    String dishName = rs.getString("name");
                    int dishPrice = rs.getInt("price");
                    String dishType = rs.getString("type");
                    dishes = new Dishes(dishId, dishName, dishPrice, dishType);
                    byPriceAndTypeResult.add(dishes);
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
        return byPriceAndTypeResult;
    }
}