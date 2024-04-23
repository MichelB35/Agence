package com.agence.agence.service;
import com.agence.agence.models.User;
import com.agence.agence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements ServiceInterface<User> {

    @Autowired
    UserRepository userRepository;
    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        User user = userRepository.findById(id).get();
        if(user != null){
            userRepository.delete(user);
        }

    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        Optional<User> user1 = userRepository.findById(id);
        return user1.isPresent()? user1.get():null;
    }

    public  int userAdmin(){
        return   userRepository.countUserRoleAdmin();
    }

    public  int userUser(){
        return   userRepository.countUserRole();
    }


    public int count(){
        return  userRepository.countIdUser();
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }
}
