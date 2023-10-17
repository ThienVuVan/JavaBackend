package com.bookuser.service;

import com.bookuser.entity.User;

import java.util.List;

public interface UserService {
    public User checklogin(User user);
    public List<User> getUser();
    public void saveUser(User user);
    public User getUser(int userId);
    public void deleteUser(int userId);
}
