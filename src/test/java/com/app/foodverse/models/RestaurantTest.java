package com.app.foodverse.models;

import com.app.foodverse.dao.RestaurantRepositoryTest;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTest {
    Restaurant restaurant = new Restaurant();
    RestaurantRepositoryTest restaurantRepositoryTest = new RestaurantRepositoryTest();

    public void initObjs() {
        restaurantRepositoryTest = new RestaurantRepositoryTest();
        restaurant = new Restaurant(restaurantRepositoryTest);
    }

    @Test
    void constructorTest() {
        Restaurant restaurantTest = new Restaurant(1, "A&W", "Chain lake Dr", "Veg", "1");
        assertEquals(1, restaurantTest.getRestaurantId());
        assertEquals("Chain lake Dr", restaurantTest.getAddress());
    }

    Restaurant testRestaurant = new Restaurant(2, "Bento", "HSC", "NonVeg", "3");

    @Test
    void getRestaurantIdPass() {
        assertNotNull(testRestaurant.getRestaurantId());
    }

    @Test
    void setRestaurantIdPass() {
        initObjs();
        restaurant.setRestaurantId(3);
        assertEquals(3, restaurant.getRestaurantId());
    }

    @Test
    void getNamePass() {
        assertNotNull(testRestaurant.getName());
    }

    @Test
    void setNamePass() {
        initObjs();
        restaurant.setName("Subway");
        assertEquals("Subway", restaurant.getName());
    }

    @Test
    void getAddressPass() {
        assertNotNull(testRestaurant.getAddress());
    }

    @Test
    void setAddressPass() {
        initObjs();
        restaurant.setAddress("Robbie St");
        assertEquals("Robbie St", restaurant.getAddress());
    }

    @Test
    void getTypePass() {
        assertNotNull(testRestaurant.getType());
    }

    @Test
    void setTypePass() {
        initObjs();
        restaurant.setType("Veg");
        assertEquals("Veg", restaurant.getType());
    }

    @Test
    void getUserIdPass() {
        assertNotNull(testRestaurant.getUserId());
    }

    @Test
    void setUserIdPass() {
        initObjs();
        restaurant.setType("2");
        assertEquals("2", restaurant.getType());
    }

    @Test
    void toStringPass() {
        String toString = "Restaurant{restaurantId=2, name='Bento', address='HSC', type='NonVeg', userId='3'}";
        assertEquals(toString, testRestaurant.toString());
    }

    @Test
    void toStringFail() {
        String toString = " ";
        assertNotEquals(toString, testRestaurant.toString());
    }

    @Test
    public void getAllRestaurants() throws SQLException {
        assertEquals(3, restaurantRepositoryTest.getALlRestaurant().size());
    }
}
