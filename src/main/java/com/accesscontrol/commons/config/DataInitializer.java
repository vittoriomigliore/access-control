package com.accesscontrol.commons.config;

import com.accesscontrol.usermanagement.entities.Role;
import com.accesscontrol.usermanagement.entities.User;
import com.accesscontrol.usermanagement.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    private static final String DEFAULT_USER = "admin";
    private static final String DEFAULT_PASSWORD = "password";
    private static final Role DEFAULT_ROLE = Role.ADMIN;

    @Bean
    CommandLineRunner init(UserService userService, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userService.findByUsername(DEFAULT_USER).isEmpty()) {
                User user = new User();
                user.setUsername(DEFAULT_USER);
                user.setPassword(passwordEncoder, DEFAULT_PASSWORD);
                user.setRole(DEFAULT_ROLE);
                userService.saveUser(user);
            }
        };
    }
}