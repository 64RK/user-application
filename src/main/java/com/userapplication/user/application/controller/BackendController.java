package com.userapplication.user.application.controller;

import com.userapplication.user.application.service.AccountService;
import com.userapplication.user.application.service.DepartmentService;
import com.userapplication.user.application.service.UserService;
import com.userapplication.user.application.bean.Account;
import com.userapplication.user.application.bean.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@org.springframework.transaction.annotation.Transactional
public class BackendController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;
    @Autowired
    private DepartmentService departmentService;

    @Transactional
    public void saveAccount(long id){
        Account account = new Account(userService.getById(id));
        accountService.save(account);
        System.out.println("updating account");
    }

    @Transactional
    public void saveDepartment(long id){
        Department department = new Department(userService.getById(id));
        departmentService.save(department);
        System.out.println("updating department");
    }

    @Transactional
    public void deleteAccount(long id){
        accountService.deleteById(id);
        System.out.println("deleting account");
    }

    @Transactional
    public void deleteDepartment(long id){
        departmentService.deleteById(id);
        System.out.println("deleting department");
    }

}
