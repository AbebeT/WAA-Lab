package com.lab3.Spring.boot.service;

import com.lab3.Spring.boot.domain.Post;
import com.lab3.Spring.boot.domain.PostV2;

import java.util.List;

public interface PostServiceV2 {
    public PostV2 getPostById(long id);
    public List<PostV2> getAll();
    public List<PostV2> add(PostV2 post);
    public List<PostV2> deleteById(long id);
    public void update(PostV2 post, long id);
}
