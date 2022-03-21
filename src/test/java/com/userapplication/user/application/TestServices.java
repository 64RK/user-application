package com.userapplication.user.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userapplication.user.application.bean.User;
import com.userapplication.user.application.controller.UserController;
import com.userapplication.user.application.repository.UserRepository;
import com.userapplication.user.application.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
public class TestServices {
    @MockBean
    private UserRepository userRepository;

    @Mock
    private UserService userService;
    @InjectMocks  //@spy
    private UserController userController;

    @Test
    public void testDecision() {

        User user = new User(100001, "user1", 34, 3545543, 3323);

//        Mockito.doNothing().when(operations).setValue1(Mockito.anyInt());
//        Mockito.doNothing().when(operations).setValue2(Mockito.anyInt());

        Mockito.doReturn(user).when(userService).getById(100001);
        long result = userController.getUserAge(100001);
        Assertions.assertEquals(34, result);

//            Mockito.doReturn(user).when(userService).getUser(100001);
        User result1 = userController.getUser(100001);
        Assertions.assertEquals(user, result1);
    }


}

//RESt test case
