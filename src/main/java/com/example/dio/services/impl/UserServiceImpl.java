package com.example.dio.services.impl;

import com.example.dio.module.User;
import com.example.dio.repository.UserRepository;
import com.example.dio.services.UserService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
