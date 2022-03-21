package com.userapplication.user.application.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    User user1 = new User(100001, "user1", 34, 3545543, 3323);
    Account account1 = new Account(user1);
    @Test
    void testToString() {
        String expected = "Account{id=100001, userName='user1', userAge=34, userAccountId=3545543}";
        String result = account1.toString();
        assertEquals(expected, result, String.valueOf(false));
    }
}