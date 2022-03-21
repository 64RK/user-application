package com.userapplication.user.application.repository;

import com.userapplication.user.application.bean.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
//    List<Account> findById(final String Name);
}

