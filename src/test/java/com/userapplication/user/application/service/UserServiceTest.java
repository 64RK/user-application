package com.userapplication.user.application.service;

import com.userapplication.user.application.bean.Department;
import com.userapplication.user.application.bean.User;
import com.userapplication.user.application.repository.DepartmentRepository;
import com.userapplication.user.application.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@WebMvcTest(UserService.class)
class UserServiceTest {

    @MockBean
    private UserRepository userRepository;
    @InjectMocks  //@spy
    private UserService userService;

    User user1 = new User(100001, "user1", 34, 3545543, 3323);
    User user2 = new User(100002, "user2", 35, 4567889, 4567);
    List<User> list = new ArrayList<>(Arrays.asList(user1, user2));

    @Test
    void getById() {
        MockitoAnnotations.openMocks(this);
        when(userRepository.findById(100001L)).thenReturn(Optional.ofNullable(user1));
        User result = userService.getById(100001);
        Assertions.assertEquals(user1, result);
    }

    @Test
    void findAll() {
        MockitoAnnotations.openMocks(this);
        when(userRepository.findAll()).thenReturn(list);
        List<User> result = userService.findAll();
        Assertions.assertEquals(list, result);
    }

    @Test
    void save() {
        MockitoAnnotations.openMocks(this);
        userService.save(user1);
        verify(userRepository).save(user1);
    }

    @Test
    void modify() {
        MockitoAnnotations.openMocks(this);
        userService.modify(100001,user1);
        verify(userRepository).save(user1);
        verify(userRepository).deleteById(100001L);
    }

    @Test
    void deleteById() {
        MockitoAnnotations.openMocks(this);
        userService.deleteById(100001);
        verify(userRepository).deleteById(100001L);
    }
}