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
    public ResponseEntity<User> createUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody User user){
        User updateUser = userService.findById(id).get();
        updateUser.setName(user.getName());
        updateUser.setAddress(user.getAddress());
        userService.saveUser(updateUser);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }

}
