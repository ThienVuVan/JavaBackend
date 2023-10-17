package com.springdatajpa.repository.custom;

import com.springdatajpa.dto.UserDto;
import com.springdatajpa.modelcustom.UserPost;

import java.util.List;

public interface UserCustomRepository{
    public List<UserPost> getUserPost();
    public List<UserPost> getUserPostByName(String username);

    public void saveUser(UserDto user);
}
