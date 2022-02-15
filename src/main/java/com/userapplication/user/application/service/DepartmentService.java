package com.userapplication.user.application.service;

import com.userapplication.user.application.bean.Department;
import com.userapplication.user.application.bean.User;
import com.userapplication.user.application.repository.DepartmentRepository;
import com.userapplication.user.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department getById(long id){
        return departmentRepository.findById(id).orElse(null);
    }


    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    public void save(Department department){
        departmentRepository.save(department);
    }

    public void deleteById(long id){
        departmentRepository.deleteById(id);
    }
}
