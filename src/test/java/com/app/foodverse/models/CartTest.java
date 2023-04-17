package com.app.foodverse.models;

import com.app.foodverse.dao.CartRepositoryTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {

    CartRepositoryTest cartRepositoryTest = new CartRepositoryTest();
    Cart cart = new Cart(cartRepositoryTest);

    public List<Dishes> dishes = new ArrayList<>();

    @AfterEach
    public void emptyCart() {
        cart.cartItems.clear();
    }

    @Test
    public void getDishByNegativeId() throws SQLException {
        int id = -1;
        assertNull(cart.getDishById(id));
    }

    @Test
    public void getDishByValidId() throws SQLException {
        int id = 1;
        assertEquals(8, cart.getDishById(id).getDishPrice());
    }

    @Test
    public void storeDishByInvalidId() throws SQLException {
        int id = -1;
        assertNull(cart.storeDishId(id));
    }

    @Test
    public void storeDishByValidId() throws SQLException {
        int id = 1;
        assertNotNull(cart.storeDishId(id));
    }

    @Test
    public void storeDishByExistingId() throws SQLException {
        cart.cartItems.add(new Dishes(1, "Paneer", 10, "Veg"));
        cart.storeDishId(1);
        assertEquals(1, cart.cartItems.size());
    }

    @Test
    public void storeDishByNewId() throws SQLException {
        cart.cartItems.add(new Dishes(1, "Paneer", 10, "Veg"));
        cart.storeDishId(2);
        assertEquals(2, cart.cartItems.size());
    }

    @Test
    public void showEmptyCartTest() {
        assertNull(cart.showCart());
    }

    @Test
    public void showNotEmptyCartTest() {
        cart.cartItems.add(new Dishes(1, "Paneer", 10, "Veg"));
        assertEquals(1, cart.showCart().get(0).getDishId());
    }

    @Test
    public void removeFromEmptyCart() {
        assertNull(cart.removeDish(1));
    }

    @Test
    public void removeFromNonEmptyCart() {
        cart.cartItems.add(new Dishes(1, "Paneer", 10, "Veg"));
        cart.removeDish(1);
        assertEquals(0, cart.cartItems.size());
    }

    @Test
    public void removeFromNonEmptyCartInvalidId() {
        cart.cartItems.add(new Dishes(1, "Paneer", 10, "Veg"));
        cart.removeDish(2);
        assertEquals(1, cart.cartItems.size());
    }

    @Test
    public void validatePaymentEmptyfield() {
        assertEquals("Each field required!!", cart.validatePayment("", "", "", ""));
    }

    @Test
    public void validatePaymentUnmatchedName() {
        assertEquals("Name should not contain numbers", cart.validatePayment("Jay12", "4321432143214321", "02/25", "321"));
    }

    @Test
    public void validatePaymentUnmatchedNumber() {
        assertEquals("Enter correct card number", cart.validatePayment("Jay", "4321432143", "02/25", "321"));
    }

    @Test
    public void validatePaymentUnmatchedExp() {
        assertEquals("Date must be in MM/YY format", cart.validatePayment("Jay", "4321432143214321", "2525", "321"));
    }

    @Test
    public void validatePaymentUnmatchedCVV() {
        assertEquals("Enter correct CVV", cart.validatePayment("Jay", "4321432143214321", "02/25", "abc"));
    }

    @Test
    public void validatePaymentCorrectDetails() {
        assertEquals("Payment Success!!", cart.validatePayment("Jay", "4321432143214321", "02/25", "321"));
    }

}
