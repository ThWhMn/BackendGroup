package com.example.userservice.client;

import com.example.userservice.pojo.News;
import com.example.userservice.pojo.RequestResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("news-service")
public interface NewsClient {
    @GetMapping("/news/getNewsByUserId")
    RequestResult<List<News>> getNewsByUserId(@RequestParam("userId")String userId);
}
