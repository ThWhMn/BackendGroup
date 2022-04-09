package com.example.springbootmybatis.controller;

import com.example.springbootmybatis.dao.UserDAO;
import com.example.springbootmybatis.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserDAO userMapper;

    @ResponseBody
    @RequestMapping("/getUserById")
    public User getUserById(String id){
        return userMapper.getUserById(id);
    }
}