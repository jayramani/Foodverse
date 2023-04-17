package com.app.foodverse.models;

import com.app.foodverse.dao.IRestaurantRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.SQLException;
import java.util.List;

public class Restaurant {

    private IRestaurantRepository restaurantRepository;
    private int restaurantId;
    private String name;
    private String address;
    private String type;
    private String userId;

    public Restaurant(int restaurantId, String name, String address, String type, String userId) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
        this.type = type;
        this.userId = userId;
    }

    public Restaurant() {

    }

    public Restaurant(IRestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "restaurantId=" + restaurantId + ", name='" + name + '\'' + ", address='" + address + '\'' + ", type='" + type + '\'' + ", userId='" + userId + '\'' + '}';
    }

    public List<Restaurant> getAllRestaurants() throws SQLException {
        return restaurantRepository.getALlRestaurant();
    }

    public String getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        return username;
    }
}
