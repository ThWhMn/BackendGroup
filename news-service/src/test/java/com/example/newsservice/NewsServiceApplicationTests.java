package com.example.newsservice;

import com.example.newsservice.controller.NewsController;
import com.example.newsservice.dao.NewsDAO;
import com.example.newsservice.pojo.News;
import com.example.newsservice.service.NewsService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class NewsServiceApplicationTests {

    @Autowired
    private NewsDAO newsDAO;

    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsController newsController;

    @Test
    void testNews() {
        News newsById;
//        newsById = newsDAO.getNewsById("0");
        newsById = newsController.getNews("0").getData();

        if (newsById == null) {
            System.out.println("No news");
        } else
            System.out.println(newsById.getId() + " " + newsById.getGmtCreate());

        List<News> ns = newsController.getNewsByUserId("0").getData();
        for (News n : ns) {
            if (n == null) {
                System.out.println("No news");
            } else
                System.out.println(n.getId() + " " + n.getGmtCreate());
        }
    }

}
