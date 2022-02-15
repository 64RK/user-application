package com.userapplication.user.application.repository;

import com.userapplication.user.application.bean.Account;
import com.userapplication.user.application.bean.Department;
import com.userapplication.user.application.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
//    List<Account> findById(final String Name);
}

