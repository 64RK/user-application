package com.userapplication.user.application.service;

import com.userapplication.user.application.bean.Account;
import com.userapplication.user.application.bean.Department;
import com.userapplication.user.application.bean.User;
import com.userapplication.user.application.repository.AccountRepository;
import com.userapplication.user.application.repository.DepartmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebMvcTest(DepartmentService.class)
class DepartmentServiceTest {

    @MockBean
    private DepartmentRepository departmentRepository;
    @InjectMocks  //@spy
    private DepartmentService departmentService;

    User user1 = new User(100001, "user1", 34, 3545543, 3323);
    User user2 = new User(100002, "user2", 35, 4567889, 4567);
    Department department1 = new Department(user1);
    Department department2 = new Department(user2);
    List<Department> list = new ArrayList<>(Arrays.asList(department1, department2));

    @Test
    void getById() {
        MockitoAnnotations.openMocks(this);
        when(departmentRepository.findById(100001L)).thenReturn(Optional.ofNullable(department1));
        Department result = departmentService.getById(100001);
        Assertions.assertEquals(department1, result);
    }

    @Test
    void findAll() {
        MockitoAnnotations.openMocks(this);
        when(departmentRepository.findAll()).thenReturn(list);
        List<Department> result = departmentService.findAll();
        Assertions.assertEquals(list, result);
    }

    @Test
    void save() {
        MockitoAnnotations.openMocks(this);
        departmentService.save(department1);
        verify(departmentRepository).save(department1);
    }

    @Test
    void deleteById() {
        MockitoAnnotations.openMocks(this);
        departmentService.deleteById(100001);
        verify(departmentRepository).deleteById(100001L);
    }
}