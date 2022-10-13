package com.devmountain.noteApp.controllers;

import com.devmountain.noteApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/v1/users") //can accept a String as an option and thats where you can designate class level path all further
// endpoints will begin at
public class UserController {
    //Autowire dependencies
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // create a method that will handle POST requests to be able to register a User
    // Create a public method that returns a List<String> called addUser that accepts an argument of type UserDto
    // called “userDto”
}
