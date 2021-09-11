package com.lab3.Spring.boot.service;

import com.lab3.Spring.boot.domain.Post;
import com.lab3.Spring.boot.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public Optional<User> findById(long id);
    public List<User> findAll();
    public void save(User user);
    public void deleteById(long id);
    // public void update(Post post);
    public List<Post> findPostsByUserId(long id);
}
