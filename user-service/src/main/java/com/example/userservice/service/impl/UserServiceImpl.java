package com.example.userservice.service.impl;

import com.example.userservice.dao.UserDAO;
import com.example.userservice.pojo.User;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Override
    public User getUser(String id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> listUsersByIds(List<String > ids) {
        List<User> userList = new ArrayList<User>();
        for (String id : ids) {
            userList.add(getUser(id));
        }
        return userList;
    }
}
