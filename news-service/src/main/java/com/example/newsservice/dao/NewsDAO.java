package com.example.newsservice.dao;

import com.example.newsservice.pojo.News;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsDAO {
    News getNewsById(String id);
    List<News> getNewsByUserId(String userId);
    int insertNews(News n);
}

