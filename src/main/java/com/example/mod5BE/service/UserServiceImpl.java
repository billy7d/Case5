package com.example.mod5BE.service;

import com.example.mod5BE.model.User;
import com.example.mod5BE.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
