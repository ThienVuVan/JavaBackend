package com.jwtsecurity.service;

import com.jwtsecurity.entity.Role;
import com.jwtsecurity.entity.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addToUser(String username, String rolename);
}
