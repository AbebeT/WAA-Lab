package com.lab3.Spring.boot.service;

import com.lab3.Spring.boot.domain.Post;

import java.util.List;

public interface PostService {
    public Post getPostById(long id);
    public List<Post> getAll();
    public void add(Post post);
    public void deleteById(long id);
    public void update(Post post);

}
