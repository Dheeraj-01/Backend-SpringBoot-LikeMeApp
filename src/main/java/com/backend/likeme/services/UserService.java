package com.backend.likeme.services;

import com.backend.likeme.payloads.MyUserDto;
import com.backend.likeme.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto registerNewUser(UserDto user);


    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    MyUserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);

    void saveFriendByUser(Integer userId, Integer friendId);
}
