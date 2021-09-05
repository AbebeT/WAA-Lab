package com.lab3.Spring.boot.service;

import com.lab3.Spring.boot.domain.Post;

import java.util.List;

public interface PostService {
    public Post getPostById(long id);
    public List<Post> getAll();
    public List<Post> add(Post post);
    public List<Post> deleteById(long id);
    public void update(Post post);

}
