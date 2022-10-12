package com.devmountain.noteApp.services;

import com.devmountain.noteApp.dtos.UserDto;

import java.util.List;

public interface UserService {
    List<String> addUser(UserDto userDto);

    List<String> userLogin(UserDto userDto);
}
