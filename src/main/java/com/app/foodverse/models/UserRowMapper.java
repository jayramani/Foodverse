package com.app.foodverse.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper {
    public static User getUser(ResultSet resultSet) throws SQLException {
        User user = null;
        while (resultSet.next()) {
            int userId = resultSet.getInt("userId");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String mobile = resultSet.getString("mobile");
            String email = resultSet.getString("email");
            String passwordHash = resultSet.getString("passwordHash");
            String role = resultSet.getString("role");
            user = new User(userId, firstName, lastName, mobile, email, passwordHash, role);
        }
        return user;
    }
}
