package com.app.foodverse.models;

import com.mockrunner.mock.jdbc.MockResultSet;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RestaurantMapperTest {
    public static MockResultSet createMockRestaurantResultSet() {
        MockResultSet mockResultSet = new MockResultSet("Restaurant");
        mockResultSet.addColumn("restaurantId", new Integer[]{123456});
        mockResultSet.addColumn("name", new String[]{"Test"});
        mockResultSet.addColumn("address", new String[]{"Admin"});
        mockResultSet.addColumn("type", new String[]{"9876543210"});
        mockResultSet.addColumn("userId", new String[]{"admin@gmail.com"});
        return mockResultSet;
    }

    @Test
    public void testRestaurantResultSet() throws SQLException {
        Restaurant restaurant = new Restaurant();
        ResultSet resultSet = createMockRestaurantResultSet();
        assertNotNull(RestaurantMapper.getRestaurant(resultSet, restaurant));
    }

}