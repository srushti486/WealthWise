package com.wealthfitness.service;

import com.wealthfitness.model.User;
import com.wealthfitness.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;      //to access student repository class

    //pass user obj to userRepository
    public User registerUser(User user) {
        return userRepository.save(user);   
    }

    //fetch by email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
