package com.userapplication.user.application.bean;

import com.userapplication.user.application.controller.UserController;
import com.userapplication.user.application.repository.UserRepository;
import com.userapplication.user.application.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @MockBean
    private UserRepository userRepository;

    @Mock
    private UserService userService;
    @InjectMocks  //@spy
    private UserController userController;

    User user1 = new User(100001, "user1", 34, 3545543, 3323);
    User user2 = new User(100002, "user2", 35, 4567889, 4567);

    @Test
    void getId() {
        long result = user1.getId();
        Assertions.assertEquals(100001, result);
    }

    @Test
    void setId() {
        user1.setId(1);
        long result = user1.getId();
        Assertions.assertEquals(1, result);
    }

    @Test
    void getUserName() {
        String result = user1.getUserName();
        Assertions.assertEquals("user1", result);
    }

    @Test
    void setUserName() {
        user1.setUserName("user2");
        String result = user1.getUserName();
        Assertions.assertEquals("user2", result);
    }

    @Test
    void getUserAge() {
        int result = user1.getUserAge();
        Assertions.assertEquals(34, result);
    }

    @Test
    void setUserAge() {
        user1.setUserAge(35);
        int result = user1.getUserAge();
        Assertions.assertEquals(35, result);
    }

    @Test
    void getUserAccountId() {
        long result = user1.getUserAccountId();
        Assertions.assertEquals(3545543, result);
    }

    @Test
    void setUserAccountId() {
        user1.setUserAccountId(4567889);
        long result = user1.getUserAccountId();
        Assertions.assertEquals(4567889, result);
    }

    @Test
    void getUserDepartmentId() {
        long result = user1.getUserDepartmentId();
        Assertions.assertEquals(3323, result);
    }

    @Test
    void setUserDepartmentId() {
        user1.setUserDepartmentId(4567);
        long result = user1.getUserDepartmentId();
        Assertions.assertEquals(4567, result);
    }

    @Test
    void testToString() {
        String expected = "User{id=100002, userName='user2', userAge=35, userAccountId=4567889, userDepartmentId=4567}";
        String result = user2.toString();
        assertEquals(expected, result, String.valueOf(false));
    }
}