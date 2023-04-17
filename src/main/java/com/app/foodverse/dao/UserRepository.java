package com.app.foodverse.dao;

import com.app.foodverse.models.User;
import com.app.foodverse.models.UserRowMapper;
import com.mysql.cj.jdbc.CallableStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUserRepository {
    public UserRepository() {
    }

    @Override
    public int addUser(User user) throws SQLException {
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall("{call saveUser(?,?,?,?,?,?,?)}").unwrap(CallableStatement.class);
            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getMobile());
            statement.setString(6, user.getPasswordHash());
            statement.setString(7, user.getRole());
            return statement.executeUpdate();
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
    public User getUserByMobile(String mobile) throws SQLException {
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        User user = null;
        try {
            statement = connection.prepareCall("{call getUserByMobile(?)}").unwrap(CallableStatement.class);
            statement.setString(1, mobile);
            boolean getResult = statement.execute();
            while (getResult) {
                ResultSet resultSet = statement.getResultSet();
                user = UserRowMapper.getUser(resultSet);
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
        return user;
    }

    @Override
    public User getUserByEmail(String email) throws SQLException {
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        User user = null;
        try {
            statement = connection.prepareCall("{call getUserByEmail(?)}").unwrap(CallableStatement.class);
            statement.setString(1, email);
            boolean getResult = statement.execute();
            while (getResult) {
                ResultSet resultSet = statement.getResultSet();
                user = UserRowMapper.getUser(resultSet);
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
        return user;
    }

    @Override
    public int approveRestaurant(String id) throws SQLException {
        Connection connection = DatabaseConnectionSingleton.getInstance().getConnection();
        CallableStatement statement = null;
        try {
            statement = connection.prepareCall("{call authorizeRole(?)}").unwrap(CallableStatement.class);
            statement.setString(1, id);
            return statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            statement.close();
            connection.close();
        }
    }

}