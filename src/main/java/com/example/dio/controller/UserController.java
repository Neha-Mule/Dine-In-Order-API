package com.example.dio.controller;

import com.example.dio.module.User;
import com.example.dio.services.UserService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<User>> registerUser(@RequestBody User user){
        user = userService.registerUser(user);
        return ResponseBuilder.success(HttpStatus.CREATED,"Created User",user);
    }

    @GetMapping("/users/{userid}")
    public ResponseEntity<ResponseStructure<User>> findUserById(@PathVariable Long userid){
        User user = userService.findUserById(userid);
        return ResponseBuilder.success(HttpStatus.OK,"User Found",user);
    }

    @PutMapping("/update/{userid}")
    public ResponseEntity<ResponseStructure<User>> updateUserById(@PathVariable Long userid,@RequestBody User user){
        user = userService.updateUserById(userid,user);
        return ResponseBuilder.success(HttpStatus.OK,"User Updated",user);
    }

    }

