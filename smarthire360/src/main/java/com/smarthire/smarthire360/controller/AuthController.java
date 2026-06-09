package com.smarthire.smarthire360.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smarthire.smarthire360.entity.User;
import com.smarthire.smarthire360.security.JwtUtil;
import com.smarthire.smarthire360.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:5173")

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {

        User loggedUser = userService.loginUser(
                user.getEmail(),
                user.getPassword());

        if (loggedUser != null) {
            return JwtUtil.generateToken(loggedUser.getEmail());
        }

        return "Invalid Credentials";
    }
}