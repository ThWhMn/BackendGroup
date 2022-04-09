package com.example.springbootmybatis.dao;

import java.util.List;

import com.example.springbootmybatis.entity.News;

public interface NewsDAO {
    News getNewsById(String id);
    List<News> getNewsByUserId(String userId);
    int insertNews(News n);
}
