package com.userapplication.user.application.service;

import com.userapplication.user.application.bean.User;
import com.userapplication.user.application.repository.UserRepository;
import org.hibernate.mapping.Set;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private void setUserRepository(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }


    public User getById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void modify(long id, User user){
        userRepository.deleteById(id);
        userRepository.save(user);
    }

    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

}
