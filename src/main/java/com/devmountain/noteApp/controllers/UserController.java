package com.devmountain.noteApp.controllers;

import com.devmountain.noteApp.dtos.UserDto;
import com.devmountain.noteApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @PostMapping("/register")
    public List<String> addUser(@RequestBody UserDto userDto){
        String passHash = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(passHash); // Invoke the “setPassword()” and pass in the "passHash" variable
        return userService.addUser(userDto); // return add user
    }
    @PostMapping("/login")
    public List<String> userLogin(@RequestBody UserDto userDto){ // method for logging a User in
        return userService.userLogin(userDto);
    }
}
