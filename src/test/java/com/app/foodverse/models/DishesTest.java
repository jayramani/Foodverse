package com.app.foodverse.models;

import com.app.foodverse.dao.DishesRepositoryTest;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DishesTest {

    DishesRepositoryTest dishesRepositoryTest = new DishesRepositoryTest();

    Dishes dishes = new Dishes(dishesRepositoryTest);

    @Test
    public void findDishByExistingName() throws SQLException {
        String name = "Paneer";
        assertEquals(1, dishes.findDishByName(name).size());

    }

    @Test
    public void findDishByNewName() throws SQLException {
        String name = "Burger";
        assertEquals(0, dishes.findDishByName(name).size());
    }

    @Test
    public void findDishByNullName() throws SQLException {
        String name = "";
        assertEquals(4, dishes.findDishByName(name).size());
    }

    @Test
    public void findAllDishes() throws SQLException {
        assertEquals(4, dishes.getAllDishes().size());
    }

    @Test
    public void findDishByTypeVeg() throws SQLException {
        String type = "Veg";
        assertEquals(2, dishes.getDishByType(type).size());
    }

    @Test
    public void findDishByNullType() throws SQLException {
        String type = "";
        assertEquals(0, dishes.getDishByType(type).size());
    }

    @Test
    public void findDishByValidMinMaxPrice() throws SQLException {
        int min = 5;
        int max = 10;
        assertEquals(3, dishes.getDishByPrice(min, max).size());
    }

    @Test
    public void findDishByInvalidMinMaxPrice() throws SQLException {
        int min = 10;
        int max = 5;
        assertEquals(0, dishes.getDishByPrice(min, max).size());
    }

    @Test
    public void findDishBySameMinMaxPrice() throws SQLException {
        int min = 7;
        int max = 7;
        assertEquals(1, dishes.getDishByPrice(min, max).size());
    }

    @Test
    public void setInvalidDishId() {
        int id = -1;
        dishes.setDishId(id);
        assertEquals(0, dishes.getDishId());
    }

    @Test
    public void setValidDishId() {
        int id = 3;
        dishes.setDishId(id);
        assertEquals(3, dishes.getDishId());
    }

    @Test
    public void setInvalidDishName() {
        dishes.setDishName("");
        assertNull(dishes.getDishName());
    }

    @Test
    public void setValidDishName() {
        dishes.setDishName("Paneer");
        assertEquals("Paneer", dishes.getDishName());
    }

    @Test
    public void setInvalidDishPrice() {
        dishes.setDishPrice(-100);
        assertEquals(0, dishes.getDishPrice());
    }

    @Test
    public void setValidDishPrice() {
        dishes.setDishPrice(100);
        assertEquals(100, dishes.getDishPrice());
    }

    @Test
    public void setInvalidDishType() {
        dishes.setDishType("");
        assertNull(dishes.getDishType());
    }

    @Test
    public void setValidDishType() {
        dishes.setDishType("Veg");
        assertEquals("Veg", dishes.getDishType());
    }

    @Test
    public void findDishByPriceandTypeEmpty() throws SQLException {
        assertEquals(1, dishes.getDishByPriceAndType("Veg", 5, 9).size());
    }
}
