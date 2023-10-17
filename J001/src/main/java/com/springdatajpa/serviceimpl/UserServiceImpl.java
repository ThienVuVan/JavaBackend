package com.springdatajpa.serviceimpl;

import com.springdatajpa.dto.UserDto;
import com.springdatajpa.model.User;
import com.springdatajpa.modelcustom.UserPost;
import com.springdatajpa.repository.UserRepository;
import com.springdatajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Long save(UserDto user) {
        userRepository.save(new User(user.getUsername(), user.getPassword()));
        return user.getId();
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll()
                .stream().map(user -> new UserDto(user.getId(), user.getUsername(), user.getPassword()))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findByName(String username) {
        return userRepository.findByUsername(username)
                .stream().map(user -> new UserDto(user.getId(), user.getUsername(), user.getPassword()))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findByPassword(String password) {
        return userRepository.findPassword(password)
                .stream().map(user -> new UserDto(user.getId(), user.getUsername(), user.getPassword()))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserPost> getUserPost() {
        return userRepository.getUserPost();
    }

    @Override
    public List<UserPost> getUserPostByName(String username) {
        return userRepository.getUserPostByName(username);
    }

    @Override
    public void addUser(UserDto user) {
        userRepository.saveUser(user);
    }

    @Transactional
    @Override
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }
}
