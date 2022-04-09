package com.example.springbootmybatis.controller;

import java.util.List;

import com.example.springbootmybatis.dao.NewsDAO;
import com.example.springbootmybatis.entity.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NewsController {

    @Autowired
    private NewsDAO newsMapper;

    @ResponseBody
    @RequestMapping("/getNewsById")
    public News getNewsById(String id){
        return newsMapper.getNewsById(id);
    }

    @ResponseBody
    @RequestMapping("/getNewsByUserId")
    public List<News> getNewsByUserId(String userId){
        return newsMapper.getNewsByUserId(userId);
    }

    /**
     * @param: msg the message string to new a News() object when GET like insertNews?msg="2,def,2,3,0,0,0,2,2"
     * @return: number of  inserted lines
     */
    @ResponseBody
    @RequestMapping("/insertNews")
    public int insertNews(String msg){
        News n = new News(msg);
        return newsMapper.insertNews(n);
    }
}