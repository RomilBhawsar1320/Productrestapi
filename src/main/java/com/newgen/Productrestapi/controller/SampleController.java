package com.newgen.Productrestapi.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newgen.Productrestapi.Model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/posts")
public class SampleController {
    @GetMapping
    public List<Post> getPosts(){

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        try {

            List<Post> posts = objectMapper.readValue(response,new TypeReference<List<Post>>(){});
            return posts.stream().filter(p ->p.getTitle().contains("explicabo")).collect(Collectors.toList());

        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
