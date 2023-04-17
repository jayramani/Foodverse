package com.app.foodverse.dao;

import com.app.foodverse.models.User;

import java.sql.SQLException;

public interface IUserRepository {
    int addUser(User user) throws SQLException;

    User getUserByMobile(String mobile) throws SQLException;

    User getUserByEmail(String email) throws SQLException;

    int approveRestaurant(String id) throws SQLException;

}
