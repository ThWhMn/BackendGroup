package com.example.ribbonservice.controller;

import com.example.userservice.pojo.RequestResult;
import com.example.userservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    @GetMapping("/{id}")
    public RequestResult getUser(@PathVariable String id) {
        return restTemplate.getForObject(userServiceUrl + "/user/{id}", RequestResult.class, id);
    }

    @GetMapping("/getByUsername")
    public RequestResult getByUsername(@RequestParam String nickname) {
        return restTemplate.getForObject(userServiceUrl + "/user/getByUsername?username={1}", RequestResult.class, nickname);
    }

    @GetMapping("/getEntityByUsername")
    public RequestResult getEntityByUsername(@RequestParam String username) {
        ResponseEntity<RequestResult> entity = restTemplate.getForEntity(userServiceUrl + "/user/getByUsername?username={1}", RequestResult.class, username);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new RequestResult("操作失败", 500);
        }
    }

    @PostMapping("/insert")
    public RequestResult insert(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/insert", user, RequestResult.class);
    }

    @PostMapping("/update")
    public RequestResult update(@RequestBody User user) {
        return restTemplate.postForObject(userServiceUrl + "/user/update", user, RequestResult.class);
    }

    @PostMapping("/delete/{id}")
    public RequestResult delete(@PathVariable Long id) {
        return restTemplate.postForObject(userServiceUrl + "/user/delete/{1}", null, RequestResult.class, id);
    }
}
