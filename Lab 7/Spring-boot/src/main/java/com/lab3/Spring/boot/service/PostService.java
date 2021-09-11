package com.lab3.Spring.boot.service;

import com.lab3.Spring.boot.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    public Optional<Post> findById(long id);
    public List<Post> findAll();
    public void save(Post post);
    public void deleteById(long id);
    // public void update(Post post);

}
