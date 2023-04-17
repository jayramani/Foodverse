package com.app.foodverse.models;

import com.mockrunner.mock.jdbc.MockResultSet;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserRowMapperTest {

    public static MockResultSet createMockResultSet() {
        MockResultSet mockResultSet = new MockResultSet("User");
        mockResultSet.addColumn("userId", new Integer[]{123456});
        mockResultSet.addColumn("firstName", new String[]{"Test"});
        mockResultSet.addColumn("lastName", new String[]{"Admin"});
        mockResultSet.addColumn("mobile", new String[]{"9876543210"});
        mockResultSet.addColumn("email", new String[]{"admin@gmail.com"});
        mockResultSet.addColumn("passwordHash", new String[]{"password"});
        mockResultSet.addColumn("role", new String[]{"ROLE_ADMIN"});
        return mockResultSet;
    }

    @Test
    public void testEmployeeResultSet() throws SQLException {
        ResultSet resultSet = createMockResultSet();
        User mappedUser = UserRowMapper.getUser(resultSet);
        assertNotNull(mappedUser);

    }

}