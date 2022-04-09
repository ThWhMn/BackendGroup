package com.example.newsservice.service.impl;

import com.example.newsservice.dao.NewsDAO;
import com.example.newsservice.pojo.News;
import com.example.newsservice.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {


    @Autowired
    private NewsDAO newsDAO;

    @Override
    public News getNews(String id) {
        return newsDAO.getNewsById(id);
    }

    @Override
    public List<News> listNewsByIds(List<String> ids) {
        List<News> newsList = new ArrayList<News>();
        for (String id : ids) {
            newsList.add(newsDAO.getNewsById(id));
        }
        return newsList;
    }

    @Override
    public List<News> getNewsByUserId(String userId) {
        return newsDAO.getNewsByUserId(userId);
    }

    @Override
    public int insertNews(News n) {
        return newsDAO.insertNews(n);
    }
}
