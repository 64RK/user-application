package com.userapplication.user.application.service;

import com.userapplication.user.application.bean.User;
import com.userapplication.user.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Component
//@Repository
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getById(long id){
        return userRepository.findById(id).orElse(null);
    }
    //controller Advice

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void save(User user){
        userRepository.save(user);
    }

    public void deleteById(long id){
        userRepository.deleteById(id);
    }

}
