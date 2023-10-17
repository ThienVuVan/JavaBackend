package com.springdatajpa.service;

import com.springdatajpa.dto.UserDto;
import com.springdatajpa.modelcustom.UserPost;

import java.util.List;

public interface UserService {
    public Long save(UserDto user);
    public List<UserDto> getAll();
    public List<UserDto> findByName(String username);
    public List<UserDto> findByPassword(String password);
    public List<UserPost> getUserPost();
    public List<UserPost> getUserPostByName(String username);
    public void addUser(UserDto user);
    public void deleteByUsername(String username);
}
