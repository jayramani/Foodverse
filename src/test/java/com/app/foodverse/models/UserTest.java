package com.app.foodverse.models;

import com.app.foodverse.dao.UserRepositoryMock;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user = new User();
    UserRepositoryMock userRepositoryMock;

    public void instantiateObjects() {
        userRepositoryMock = new UserRepositoryMock();
        user = new User(userRepositoryMock);
    }

    User testUser = new User(123456, "Test", "User", "9876543210", "test@gmail.com", "12354689", "ROLE_CUSTOMER");

    @Test
    void constructorTest() {
        User conTest = new User(987654, "Test", "Restaurant", "9876543210", "restaurant@gmail.com", "12354689", "ROLE_RESTAURANT");
        assertEquals(987654, conTest.getUserId());
        assertEquals("Restaurant", conTest.getLastName());
    }

    @Test
    void generateRandomIdTest() {
        assertNotNull(testUser.generateId());
    }

    @Test
    void toStringPassTest() {
        String expected = "User{userId=123456, firstName='Test', lastName='User', mobile='9876543210', email='test@gmail.com', passwordHash='12354689', role='ROLE_CUSTOMER'}";
        assertEquals(expected, testUser.toString());
    }

    @Test
    void toStringFailTest() {
        String expected = " ";
        assertNotEquals(expected, testUser.toString());
    }

    @Test
    void getUserIdPassTest() {
        assertNotNull(testUser.getUserId());
    }

    @Test
    void setUserIdPassTest() {
        instantiateObjects();
        user.setUserId(999999);
        assertEquals(999999, user.getUserId());
    }

    @Test
    void getFirstNamePassTest() {
        assertNotNull(testUser.getFirstName());
    }

    @Test
    void setFirstNamePassTest() {
        instantiateObjects();
        user.setFirstName("TestFirstName");
        assertEquals("TestFirstName", user.getFirstName());
    }

    @Test
    void getLastNamePassTest() {
        assertNotNull(testUser.getLastName());

    }

    @Test
    void setLastNamePassTest() {
        instantiateObjects();
        user.setLastName("TestLastName");
        assertEquals("TestLastName", user.getLastName());
    }

    @Test
    void getMobilePassTest() {
        assertNotNull(testUser.getMobile());

    }

    @Test
    void setMobilePassTest() {
        instantiateObjects();
        user.setMobile("9876543210");
        assertEquals("9876543210", user.getMobile());
    }

    @Test
    void getEmailPassTest() {
        assertNotNull(testUser.getEmail());
    }

    @Test
    void setEmailPassTest() {
        instantiateObjects();
        user.setEmail("testmail@gmail.com");
        assertEquals("testmail@gmail.com", user.getEmail());
    }

    @Test
    void getPasswordHash() {
        assertNotNull(testUser.getPasswordHash());
    }

    @Test
    void setPasswordHashPassTest() {
        instantiateObjects();
        user.setPasswordHash("passwordHash");
        assertEquals("passwordHash", user.getPasswordHash());
    }

    @Test
    void getRolePassTest() {
        assertNotNull(testUser.getRole());
    }

    @Test
    void setRolePassTest() {
        instantiateObjects();
        user.setRole("ROLE_ADMIN");
        assertEquals("ROLE_ADMIN", user.getRole());
    }

    @Test
    void getPasswordEncoder() {
        assertNotNull(testUser.getPasswordEncoder());
    }

    @Test
    void addUserPassTest() throws SQLException {
        instantiateObjects();
        UserRepositoryMock userRepositoryMock = new UserRepositoryMock();
        int expectedMockSize = userRepositoryMock.getMockSize() + 1;
        int mockSizeAfterAdd = user.addUser(testUser);
        assertEquals(expectedMockSize, mockSizeAfterAdd);
    }

    @Test
    void getUserByMobilePassTest() throws SQLException {
        User user = new User(new UserRepositoryMock());
        String mobile = "9879879999";
        assertNotNull(user.getUserByMobile(mobile));
    }

    @Test
    void getUserByMobileFailTest() throws SQLException {
        User user = new User(new UserRepositoryMock());
        String mobile = "9879870000";
        assertNull(user.getUserByMobile(mobile));
    }

    @Test
    void getUserByEmailPassTest() throws SQLException {
        User user = new User(new UserRepositoryMock());
        String email = "admintest@gmail.com";
        assertNotNull(user.getUserByEmail(email));
    }

    @Test
    void getUserByEmailFailTest() throws SQLException {
        User user = new User(new UserRepositoryMock());
        String email = "notadmintest@gmail.com";
        assertNull(user.getUserByEmail(email));
    }

    @Test
    void approveRestaurantTest() throws SQLException {
        User user = new User(new UserRepositoryMock());
        assertEquals(1, user.approveRestaurant("requesttest@gmail.com"));
    }
}