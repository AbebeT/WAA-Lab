package com.lab3.Spring.boot.controller;

import com.lab3.Spring.boot.domain.Post;
import com.lab3.Spring.boot.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @RequestMapping
    List<Post> getAllPost(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    Optional<Post> getPostById(@PathVariable long id){
        return postService.findById(id);
    }

    @DeleteMapping("/{id}")
    void deletePost(@PathVariable("id") long id ){
        postService.deletePostById(id);
    }

    @PostMapping
    void addPost(@RequestBody  Post post){
        postService.save(post);
    }




//    @PutMapping
//    void updatePost(@RequestBody Post post){
//        postService.update(post);
//    }



}
