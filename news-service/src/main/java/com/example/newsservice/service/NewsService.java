package com.example.newsservice.service;

import com.example.newsservice.pojo.News;

import java.util.List;


public interface NewsService {
    News getNews(String id);
    List<News> listNewsByIds(List<String > ids);
    List<News> getNewsByUserId(String userId);
    int insertNews(News n);
}
