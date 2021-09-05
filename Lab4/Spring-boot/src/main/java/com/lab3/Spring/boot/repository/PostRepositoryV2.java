package com.lab3.Spring.boot.repository;

import com.lab3.Spring.boot.domain.Post;
import com.lab3.Spring.boot.domain.PostV2;

import java.util.List;

public interface PostRepositoryV2 {
    public PostV2 getPostById(long id);
    public List<PostV2> getAll();
    public List<PostV2> save(PostV2 post);
    public List<PostV2> deleteById(long id);
    public void update(PostV2 post);
}
