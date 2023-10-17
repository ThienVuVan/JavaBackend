package com.bookuser.serviceimpl;

import com.bookuser.dao.UserDao;
import com.bookuser.entity.User;
import com.bookuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User checklogin(User user) {
        return userDao.checklogin(user);
    }

    @Override
    public List<User> getUser() {
        return userDao.getUser();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUser(int userId) {
        return userDao.getUser(userId);
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }
}
