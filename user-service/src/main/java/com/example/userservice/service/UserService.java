package com.example.userservice.service;

import com.example.userservice.pojo.User;

import java.util.List;

public interface UserService {
    User getUser(String id);
    List<User> listUsersByIds(List<String > ids);
}
