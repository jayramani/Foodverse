package com.app.foodverse.dao;

import com.app.foodverse.models.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryMock implements IUserRepository {

    private final List<User> users;

    public int getMockSize() {
        return users.size();
    }

    public UserRepositoryMock() {
        users = new ArrayList<>();
        User user1 = new User(111111, "Admin", "Test", "9879879999", "admintest@gmail.com", "AdminPassword", "ROLE_ADMIN");
        User user2 = new User(222222, "Customer", "Test", "8798798888", "customertest@gmail.com", "CustomerPassword", "ROLE_CUSTOMER");
        User user3 = new User(333333, "Restaurant", "Test", "7987987777", "restauranttest@gmail.com", "RestaurantPassword", "ROLE_RESTAURANT");
        User user4 = new User(444444, "Request", "Test", "7987987887", "requesttest@gmail.com", "RequestPassword", "ROLE_REQUESTED");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }

    @Override
    public int addUser(User user) {
        if (user != null) {
            users.add(user);
        }
        return users.size();
    }

    @Override
    public User getUserByMobile(String mobile) {
        for (User user : users) {
            if (user.getMobile().equals(mobile)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public int approveRestaurant(String id) throws SQLException {
        for (User user : users) {
            if (user.getEmail().equals(id)) {
                user.setRole("ROLE_RESTAURANT");
                return 1;
            }
        }
        return 0;
    }
}