package com.newgen.Productrestapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/posts")
public class SampleController {
    @GetMapping
    public String posts(){

        RestTemplate restTemplate = new RestTemplate();
        String posts = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);
        return posts;

    }
}
