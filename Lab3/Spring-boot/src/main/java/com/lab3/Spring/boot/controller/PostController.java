package com.lab3.Spring.boot.controller;

import com.lab3.Spring.boot.domain.Post;
import com.lab3.Spring.boot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @RequestMapping
    List<Post> getAllPost(){
        return postService.getAll();
    }

    @GetMapping("/{id}")
    Post getPostById(@PathVariable long id){
        return postService.getPostById(id);
    }

    @DeleteMapping("/{id}")
    void deletePost(@PathVariable long id ){
        postService.deleteById(id);
    }

    @PostMapping
    void addPost(@RequestBody  Post post){
        postService.add(post);
    }

    @PutMapping
    void updatePost(@RequestBody Post post){
        postService.update(post);
    }



}
