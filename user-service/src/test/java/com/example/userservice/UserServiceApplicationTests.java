package com.example.userservice;

import com.example.userservice.controller.UserController;
import com.example.userservice.dao.UserDAO;
import com.example.userservice.pojo.News;
import com.example.userservice.pojo.User;
import com.example.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@EnableFeignClients
@RunWith(SpringJUnit4ClassRunner.class)
class UserServiceApplicationTests {

    @Autowired
    private UserDAO userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;

    @Test
    void testUser() {
        User userById;
//        userById = userDao.getUserById("0");
//        userById = userService.getUser("0");
        userById = userController.getUser("0").getData();
        if (userById == null) {
            System.out.println("No user\n");
        } else
            System.out.println(userById.getId() + " " + userById.getPhone());// + " " + userById.getName());

//        List<String> ids = new ArrayList<String >(Arrays.asList("0", "1", "3"));
//        List<User> users = userController.listUsersByIds(ids).getData();
//        for (User i : users) {
//            if (i == null) {
//                System.out.println("No user\n");
//            } else
//                System.out.println(i.getId() + " " + i.getPhone());// + " " + userById.getName());
//
//        }

        List<News> news = userController.getNewsByUserId("0").getData();
        for (News i : news) {
            if (i == null) {
                System.out.println("No user\n");
            } else
                System.out.println(i.getId() + " " + i.getGmtCreate());// + " " + userById.getName());

        }
    }
}
