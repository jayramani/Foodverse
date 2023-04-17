package com.app.foodverse.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DishTest {
    Dish dish = new Dish();

    @Test
    void constructorTest() {
        Dish dishTest = new Dish(1, "Biryani", 10, "Veg");
        assertEquals(1, dishTest.getId());
        assertEquals("Biryani", dishTest.getName());
    }

    Dish dish1 = new Dish(2, "Udon", 12, "NonVeg");

    @Test
    void getIdPass() {
        assertNotNull(dish1.getId());
    }

    @Test
    void setIdPass() {
        dish.setId(3);
        assertEquals(3, dish.getId());
    }

    @Test
    void getNamePass() {
        assertNotNull(dish1.getName());
    }

    @Test
    void setNamePass() {
        dish.setName("Burger");
        assertEquals("Burger", dish.getName());
    }

    @Test
    void getPricePass() {
        assertNotNull(dish1.getPrice());
    }

    @Test
    void setPricePass() {
        dish.setPrice(9);
        assertEquals(9, dish.getPrice());
    }

    @Test
    void getTypePass() {
        assertNotNull(dish1.getType());
    }

    @Test
    void setTypePass() {
        dish.setType("NonVeg");
        assertEquals("NonVeg", dish.getType());
    }

    @Test
    void toStringPass() {
        String string = "Dish{id=2, name='Udon', price=12, type='NonVeg'}";
        assertEquals(string, dish1.toString());
    }

    @Test
    void toStringFail() {
        String toString = " ";
        assertNotEquals(toString, dish1.toString());
    }
}
