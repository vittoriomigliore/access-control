package com.accesscontrol.usermanagement.services;

import com.accesscontrol.usermanagement.controllers.api.UpdateUserRequest;
import com.accesscontrol.usermanagement.entities.User;
import com.accesscontrol.usermanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, UpdateUserRequest updateUserRequest) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updateUserRequest.getUsername());
            user.setPassword(passwordEncoder, updateUserRequest.getPassword());
            user.setRole(updateUserRequest.getRole());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
