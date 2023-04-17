package com.app.foodverse.dao;

import com.app.foodverse.models.Dishes;

import java.util.ArrayList;
import java.util.List;

public class CartRepositoryTest implements ICartRepository {

    public List<Dishes> dishesList;

    public CartRepositoryTest() {
        dishesList = new ArrayList<>();
        Dishes d1 = new Dishes(1, "Paneer Sandwich", 8, "Veg");
        Dishes d2 = new Dishes(2, "Biryani", 11, "Veg");
        Dishes d3 = new Dishes(3, "Chicken Tikka", 7, "Nonveg");
        Dishes d4 = new Dishes(4, "Nonveg Combo", 9, "Nonveg");
        dishesList.add(d1);
        dishesList.add(d2);
        dishesList.add(d3);
        dishesList.add(d4);
    }

    public Dishes getDishById(int id) {
        if (id <= 0 || id > dishesList.size()) {
            return null;
        }
        else {
            return dishesList.get(id - 1);
        }
    }
}
