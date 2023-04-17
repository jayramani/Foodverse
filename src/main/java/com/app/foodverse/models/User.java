package com.app.foodverse.models;

import com.app.foodverse.dao.IUserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.SQLException;
import java.util.Random;

public class User {

    private IUserRepository userPersistent;
    private int userId;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String passwordHash;
    private String role;

    public User(int userId, String firstName, String lastName, String mobile, String email, String passwordHash,
                String role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }

    public User(IUserRepository userPersistent) {
        this.userPersistent = userPersistent;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", mobile='" + mobile + '\'' + ", email='" + email + '\'' + ", passwordHash='" + passwordHash + '\'' + ", role='" + role + '\'' + '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int generateId() {
        int randomId = 0;
        Random rand = new Random();
        for (int j = 0; j < 10; j++) {
            randomId = Math.abs(rand.nextInt());
        }
        return randomId;
    }

    public int addUser(User model) throws SQLException {
        this.setUserId(generateId());
        this.setFirstName(model.getFirstName());
        this.setLastName(model.getLastName());
        this.setMobile(model.getMobile());
        this.setEmail(model.getEmail());
        this.setPasswordHash(getPasswordEncoder().encode(model.getPasswordHash()));
        this.setRole(model.getRole());
        return userPersistent.addUser(this);
    }

    public User getUserByMobile(String mobile) throws SQLException {
        return userPersistent.getUserByMobile(mobile);
    }

    public User getUserByEmail(String email) throws SQLException {
        return userPersistent.getUserByEmail(email);
    }

    public int approveRestaurant(String id) throws SQLException {
        return userPersistent.approveRestaurant(id);
    }

    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
