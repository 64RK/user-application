package com.userapplication.user.application.controller;

import com.userapplication.user.application.bean.Account;
import com.userapplication.user.application.bean.Department;
import com.userapplication.user.application.bean.User;
import com.userapplication.user.application.repository.AccountRepository;
import com.userapplication.user.application.repository.DepartmentRepository;
import com.userapplication.user.application.repository.UserRepository;
import com.userapplication.user.application.service.AccountService;
import com.userapplication.user.application.service.DepartmentService;
import com.userapplication.user.application.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@WebMvcTest(BackendService.class)
class BackendServiceTest {

    @MockBean
    private AccountRepository accountRepository;
    @MockBean
    private AccountService accountService;

    @MockBean
    private DepartmentRepository departmentRepository;
    @MockBean
    private DepartmentService departmentService;

    @MockBean
    private UserRepository userRepository;
    @MockBean
    private UserService userService;

    @InjectMocks
    private BackendService backendService;


    User user1 = new User(100001, "user1", 34, 3545543, 3323);
    User user2 = new User(100002, "user2", 35, 4567889, 4567);
    Account account1 = new Account(user1);
    Department department1 = new Department(user1);

    @Test
    void saveAccount() {
        MockitoAnnotations.openMocks(this);
        when(userService.getById(100001)).thenReturn(user1);
        ArgumentCaptor<Account> valueCapture = ArgumentCaptor.forClass(Account.class);
        doNothing().when(accountService).save(valueCapture.capture());

        backendService.saveAccount(100001);
        assertEquals(account1.toString(), valueCapture.getValue().toString());
    }

    @Test
    void saveDepartment() {
        MockitoAnnotations.openMocks(this);
        when(userService.getById(100001)).thenReturn(user1);
        ArgumentCaptor<Department> valueCapture = ArgumentCaptor.forClass(Department.class);
        doNothing().when(departmentService).save(valueCapture.capture());

        backendService.saveDepartment(100001);
        assertEquals(department1.toString(), valueCapture.getValue().toString());
    }

    @Test
    void deleteAccount() {
        MockitoAnnotations.openMocks(this);
        ArgumentCaptor<Long> valueCapture = ArgumentCaptor.forClass(long.class);
        doNothing().when(accountService).deleteById(valueCapture.capture());

        backendService.deleteAccount(100001);
        assertEquals(100001, valueCapture.getValue());
    }

    @Test
    void deleteDepartment() {
        MockitoAnnotations.openMocks(this);
        ArgumentCaptor<Long> valueCapture = ArgumentCaptor.forClass(long.class);
        doNothing().when(departmentService).deleteById(valueCapture.capture());

        backendService.deleteDepartment(100001);
        assertEquals(100001, valueCapture.getValue());
    }
}