package com.lab3.Spring.boot.controller;

import com.lab3.Spring.boot.domain.Post;
import com.lab3.Spring.boot.domain.User;
import com.lab3.Spring.boot.service.PostService;
import com.lab3.Spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PostService postService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        userService.save(user);
    }
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable long id){
        return userService.findById(id);
    }

    @GetMapping("/{id}/posts")
    public List<Post> getUserPosts(@PathVariable long id){
        return userService.findPostsByUserId(id);
    }
    @GetMapping("/{id}/posts/{id2}")
    public Post getUserPostsById(@PathVariable long id, @PathVariable long id2){
        return userService.findPostsByUserId(id).stream().filter(p->p.getId() == id2).findFirst().get();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteById(id);
    }

}
