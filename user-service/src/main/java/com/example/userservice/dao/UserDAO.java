package com.example.userservice.dao;

import com.example.userservice.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    User getUserById(String id);
}
