package com.lab3.Spring.boot.controller;

import com.lab3.Spring.boot.domain.Post;
import com.lab3.Spring.boot.domain.PostV2;
import com.lab3.Spring.boot.service.PostService;
import com.lab3.Spring.boot.service.PostServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    PostServiceV2 postServiceV2;

    @RequestMapping(headers = "X-API-VERSION=1")
    public List<Post> getAllPostV1() {
        return postService.getAll();
    }

    @RequestMapping(headers = "X-API-VERSION=2")
    public List<PostV2> getAllPostV2() {
        System.out.println("all posts version 2: " + postServiceV2.getAll());
        return postServiceV2.getAll();
    }

    @GetMapping(value = "/{id}", headers = "X-API-VERSION=1")
    public EntityModel<Post> getPostById(@PathVariable long id) {


        Post post = postService.getPostById(id);

        EntityModel<Post> resource = EntityModel.of(post);

        WebMvcLinkBuilder linkToAllPosts = WebMvcLinkBuilder
                .linkTo(
                        WebMvcLinkBuilder.methodOn(this.getClass()).addPost(new Post()));
        resource.add(linkToAllPosts.withRel("post"));

        WebMvcLinkBuilder linkToDelete = WebMvcLinkBuilder
                .linkTo(
                        WebMvcLinkBuilder.methodOn(this.getClass()).deletePost(1));
        resource.add(linkToDelete.withRel("delete-post"));


        return resource;
    }

    @GetMapping(value = "/{id}", headers = "X-API-VERSION=2")
    public EntityModel<PostV2> getPostByIdV2(@PathVariable long id) {


        PostV2 post = postServiceV2.getPostById(id);

        EntityModel<PostV2> resource = EntityModel.of(post);


        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass()).getAllPostV1());
        resource.add(linkBuilder.withRel("all-posts"));

        WebMvcLinkBuilder linkToAllPosts = WebMvcLinkBuilder
                .linkTo(
                        WebMvcLinkBuilder.methodOn(this.getClass()).addPostV2(new PostV2()));
        resource.add(linkToAllPosts.withRel("add-post"));

        WebMvcLinkBuilder linkToDelete = WebMvcLinkBuilder
                .linkTo(
                        WebMvcLinkBuilder.methodOn(this.getClass()).deletePostV2(1));
        resource.add(linkToDelete.withRel("delete-post"));


        return resource;
    }

    @DeleteMapping(value = "/{id}", headers = "X-API-VERSION=1")
    public List<Post> deletePost(@PathVariable long id) {
        return postService.deleteById(id);
    }

    @DeleteMapping(value = "/{id}", headers = "X-API-VERSION=2")
    public List<PostV2> deletePostV2(@PathVariable long id) {
        return postServiceV2.deleteById(id);
    }

    @PostMapping(headers = "X-API-VERSION=1")
    public List<Post> addPost(@RequestBody Post post) {
        return postService.add(post);
    }

    @PostMapping(headers = "X-API-VERSION=2")
    public List<PostV2> addPostV2(@RequestBody PostV2 post) {
        return postServiceV2.add(post);
    }

    @PutMapping
    void updatePost(@RequestBody Post post) {
        postService.update(post);
    }


}
