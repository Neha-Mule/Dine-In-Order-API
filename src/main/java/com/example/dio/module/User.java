package com.example.dio.module;

import com.example.dio.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private  String email;

    @Column(name = "password")
    private String password;

    @Column(name = "pho_no")
    private String phoneNumber;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "last_modified_at")
    private LocalDate lastModifiedAt;
}
