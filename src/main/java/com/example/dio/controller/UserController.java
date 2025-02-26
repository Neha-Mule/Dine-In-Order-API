package com.example.dio.controller;

import com.example.dio.module.User;
import com.example.dio.services.UserService;
import com.example.dio.util.ResponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<User>> registerUser(User user){
        user = userService.registerUser(user);

        ResponseStructure<User> structure = new ResponseStructure<>();
        structure.setData(user);
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("User Created");

        return  new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
    }
}
