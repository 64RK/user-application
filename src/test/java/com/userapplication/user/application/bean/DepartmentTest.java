package com.userapplication.user.application.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    User user1 = new User(100001, "user1", 34, 3545543, 3323);
    Department department1 = new Department(user1);
    @Test
    void testToString() {
        String expected = "Department{id=100001, userName='user1', userAge=34, userDepartmentId=3323}";
        String result = department1.toString();
        assertEquals(expected, result, String.valueOf(false));
    }
}