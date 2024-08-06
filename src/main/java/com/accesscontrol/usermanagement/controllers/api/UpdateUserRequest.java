package com.accesscontrol.usermanagement.controllers.api;

import com.accesscontrol.usermanagement.entities.Role;

public class UpdateUserRequest {
    private final String username;
    private final String password;
    private final Role role;

    UpdateUserRequest(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
