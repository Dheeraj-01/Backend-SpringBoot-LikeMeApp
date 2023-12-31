package com.backend.likeme.controllers;

import com.backend.likeme.payloads.ApiResponse;
import com.backend.likeme.payloads.UserDto;
import com.backend.likeme.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserControllers {
    @Autowired
    private UserService userService;

    // POST-create user
    @PostMapping("/user/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    // PUT- update user
    @PutMapping("/user/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uid) {
        UserDto updatedUser = this.userService.updateUser(userDto, uid);
        return ResponseEntity.ok(updatedUser);
    }

    //ADMIN
    // DELETE -delete user
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid) {
        this.userService.deleteUser(uid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
    }

    // GET - user get
    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    // GET - user get
    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
