package com.smarthire.smarthire360.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smarthire.smarthire360.entity.User;
import com.smarthire.smarthire360.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(
            @RequestBody User user) {

        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(
            @RequestParam String email,
            @RequestParam String password) {

        return userService.loginUser(
                email,
                password);
    }
}