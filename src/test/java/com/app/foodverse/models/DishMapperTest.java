package com.app.foodverse.models;

import com.mockrunner.mock.jdbc.MockResultSet;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DishMapperTest {
    public static MockResultSet createMockDishResultSet() {
        MockResultSet mockResultSet = new MockResultSet("Dish");
        mockResultSet.addColumn("id", new Integer[]{123456});
        mockResultSet.addColumn("name", new String[]{"Pizza"});
        mockResultSet.addColumn("price", new Integer[]{20});
        mockResultSet.addColumn("type", new String[]{"Veg"});
        return mockResultSet;
    }

    @Test
    public void testRestaurantResultSet() throws SQLException {
        Dish dish = new Dish();
        ResultSet resultSet = createMockDishResultSet();
        assertNotNull(DishMapper.getDish(resultSet, dish));
    }

}