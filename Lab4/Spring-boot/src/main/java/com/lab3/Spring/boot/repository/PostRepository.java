package com.lab3.Spring.boot.repository;

import com.lab3.Spring.boot.domain.Post;

import java.util.List;

public interface PostRepository {
    public Post getPostById(long id);
    public List<Post> getAll();
    public List<Post> save(Post post);
    public List<Post> deleteById(long id);
    public void update(Post post, long id);
}
