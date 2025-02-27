package com.example.dio.services.impl;

import com.example.dio.enums.UserRole;
import com.example.dio.module.Admin;
import com.example.dio.module.Staff;
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
    public User registerUser(User user)
    {
        User user1 = createUserByRole(user.getUserRole());
        this.mapToNewUser(user,user1);


        return userRepository.save(user1);
    }

    private User createUserByRole(UserRole role){
        User user;
        switch (role){
            case ADMIN -> user = new Admin();
            case STAFF -> user = new Staff();
            default -> throw new RuntimeException("Failed to register user,Ivalid User");

        }
        return user;
    }

    private void mapToNewUser(User user,User user2){
        user2.setUserName(user.getUserName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setUserRole(user.getUserRole());
        user2.setPhoneNumber(user.getPhoneNumber());
    }
}
