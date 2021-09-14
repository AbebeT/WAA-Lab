package com.lab3.Spring.boot.controller;
import com.lab3.Spring.boot.domain.Post;
import com.lab3.Spring.boot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    PostService postService;

    @GetMapping("/home")
    public String homepage() {


        List<Post> posts =  postService.findAll();
        System.out.println(posts.get(0).getAuthor());

        return "index";
    }

}