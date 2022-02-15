package com.userapplication.user.application.repository;

import com.userapplication.user.application.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    List<User> findById(final String Name);
}
