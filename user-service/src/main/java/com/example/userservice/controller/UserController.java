package com.example.userservice.controller;

import com.example.userservice.client.NewsClient;
import com.example.userservice.pojo.News;
import com.example.userservice.pojo.RequestResult;
import com.example.userservice.pojo.User;
import com.example.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author myself
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    final
    NewsClient newsClient;

    private final UserService userService;

    public UserController(UserService userService, NewsClient newsClient) {
        this.userService = userService;
        this.newsClient = newsClient;
    }

    @GetMapping("/getUserById")
    public RequestResult<User> getUser(@RequestParam("id") String  id) {
        User user = userService.getUser(id);
        LOGGER.info("根据id获取用户信息，用户名称为：{}",user.getNickname());
        return new RequestResult<>(user);
    }

    @GetMapping("/getUsersByIds")
    public RequestResult<List<User>> getUsersByIds(@RequestParam List<String> ids) {
        List<User> userList= userService.listUsersByIds(ids);
        LOGGER.info("根据ids获取用户信息，用户列表为：{}",userList);
        return new RequestResult<>(userList);
    }

    @GetMapping("/getNewsByUserId")
    public RequestResult<List<News>> getNewsByUserId(String userId) {
        RequestResult<List<News>> res = newsClient.getNewsByUserId(userId);
        LOGGER.info("根据用户id获取新闻信息，用户列表为：{}", res.getData());
        return newsClient.getNewsByUserId(userId);
    }
}
