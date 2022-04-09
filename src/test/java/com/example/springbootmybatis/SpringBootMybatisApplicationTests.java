package com.example.springbootmybatis;

import java.util.List;

import com.example.springbootmybatis.controller.NewsController;
import com.example.springbootmybatis.dao.NewsDAO;
import com.example.springbootmybatis.dao.UserDAO;
import com.example.springbootmybatis.entity.News;
import com.example.springbootmybatis.entity.User;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// import javax.sql.DataSource;
// import java.sql.Connection;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;

@SpringBootTest
// 使其运行在spring环境中进行测试.
// @RunWith如果没有，需要添加Junit依赖，解决方法参考下述
@RunWith(SpringJUnit4ClassRunner.class)
class SpringBootMybatisApplicationTests {

    // @Autowired
    // private DataSource dataSource;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private NewsDAO newsDao;

    @Autowired
    private NewsController newsController;
    // @Test
    // void contextLoads() throws SQLException {
    // Connection connection = dataSource.getConnection();
    // Statement statement = connection.createStatement();
    // ResultSet resultSet = statement.executeQuery("select * from user");

    // while(resultSet.next()){
    // int id = resultSet.getInt(1);
    // String name = resultSet.getString(2);
    // String address = resultSet.getString(3);
    // System.out.println("id:" + id + " name:" + name + " address:" + address);
    // }
    // }

    @Test
    void testUserDAO() {
        User userById = userDao.getUserById("0");
        if (userById == null) {
            System.out.println("No user\n");
        } else
            System.out.println(userById.getId() + " " + userById.getPhone());// + " " + userById.getName());
    }

    @Test
    void testNewsDAO() {
        String id = "0";
        // News newsById = newsMapper.getNewsById(id);
        // System.out.println(newsById.getId() + " " + newsById.getGmtCreate());// + " " + userById.getName());

        List<News> newsByUserId = newsDao.getNewsByUserId(id);
        for (News n : newsByUserId) {
            System.out.println(n.getId() + " " + n.getGmtCreate());// + " " + userById.getName());
        }
    }

    @Test
    void testNewsController() {
        String msg = "2,def,2,3,0,0,0,2,2";
        System.out.println("Inserted num: " + newsController.insertNews(msg));// + " " + userById.getName());
    }

    @Test
    void testNewsClass() {
        String msg = "2,def,2,3,0,0,0,2,2";
        News n = new News(msg);
        System.out.println(n.getId() + " " + n.getGmtCreate());// + " " + userById.getName());
    }

}