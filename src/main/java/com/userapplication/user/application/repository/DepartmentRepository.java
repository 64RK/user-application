package com.userapplication.user.application.repository;

import com.userapplication.user.application.bean.Account;
import com.userapplication.user.application.bean.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
