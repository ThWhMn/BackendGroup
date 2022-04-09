package com.example.newsservice.controller;

import com.example.newsservice.pojo.News;
import com.example.newsservice.pojo.RequestResult;
import com.example.newsservice.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author myself
 */
@RestController
@RequestMapping(value = "/news")
public class NewsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsController.class);

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/getNewsById")
    public RequestResult<News> getNews(String id) {
        News news = newsService.getNews(id);
        LOGGER.info("根据id获取新闻信息，新闻标题为：{}", news.getTitle());
        return new RequestResult<>(news);
    }

    @GetMapping("/getNewsByUserId")
    public RequestResult<List<News>> getNewsByUserId(String userId) {
        List<News> newsList = newsService.getNewsByUserId(userId);
        LOGGER.info("根据用户id获取新闻信息，新闻列表为：{}", newsList);
        return new RequestResult<>(newsList);
    }
}
