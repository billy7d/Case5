package com.example.mod5BE.controller;


import com.example.mod5BE.model.User;
import com.example.mod5BE.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<Iterable<User>> listUsers(){
       Iterable<User> users =  userService.findAll();
       return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(User user){
        userService.saveUser(user);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> editUser(@PathVariable Long id){
        User user = userService.findById(id).get();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
