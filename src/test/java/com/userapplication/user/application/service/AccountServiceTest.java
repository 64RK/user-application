package com.userapplication.user.application.service;

import com.userapplication.user.application.bean.Account;
import com.userapplication.user.application.bean.User;
import com.userapplication.user.application.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@WebMvcTest(AccountService.class)
class AccountServiceTest {


    @MockBean
    private AccountRepository accountRepository;
    @InjectMocks  //@spy
    private AccountService accountService;

    User user1 = new User(100001, "user1", 34, 3545543, 3323);
    User user2 = new User(100002, "user2", 35, 4567889, 4567);
    Account account1 = new Account(user1);
    Account account2 = new Account(user2);
    List<Account> list = new ArrayList<>(Arrays.asList(account1, account2));
//    List spy = spy(list);

    @Test
    void getById() {
        MockitoAnnotations.openMocks(this);
        when(accountRepository.findById(100001L)).thenReturn(Optional.ofNullable(account1));
        Account result = accountService.getById(100001);
        Assertions.assertEquals(account1, result);
    }

    @Test
    void findAll() {
        MockitoAnnotations.openMocks(this);
        when(accountRepository.findAll()).thenReturn(list);
        List<Account> result = accountService.findAll();
        Assertions.assertEquals(list, result);
    }

    @Test
    void save() {
        MockitoAnnotations.openMocks(this);
        accountService.save(account1);
        verify(accountRepository).save(account1);
    }

    @Test
    void deleteById() {
        MockitoAnnotations.openMocks(this);
        accountService.deleteById(100001);
        verify(accountRepository).deleteById(100001L);
    }
}