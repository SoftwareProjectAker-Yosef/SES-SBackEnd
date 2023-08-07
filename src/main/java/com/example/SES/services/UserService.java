package com.example.SES.services;

import com.example.SES.models.User;
import com.example.SES.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
public class UserService {


    @Autowired
    private UserRepo userRepo;

    public List<User> getAllUsers() {

        return userRepo.findAll();

    }


    public User getUser(String email)  {


        return userRepo.findByEmail(email).orElseGet(()->User.builder().build());

    }

    public void addUser(User user) {

        userRepo.save(user);
    }

    public Boolean userExists(String email) {

        return userRepo.existsByEmail(email);
    }


}