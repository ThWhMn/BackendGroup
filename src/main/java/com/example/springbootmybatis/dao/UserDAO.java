package com.example.springbootmybatis.dao;

import com.example.springbootmybatis.entity.User;

public interface UserDAO {
    User getUserById(String id);
}
