package com.example.mod5BE.service;

import com.example.mod5BE.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {

    Iterable<User> findAll();

    User saveUser(User user);

    Optional<User> findById(Long id);

    User deleteUser(Long id);
}
