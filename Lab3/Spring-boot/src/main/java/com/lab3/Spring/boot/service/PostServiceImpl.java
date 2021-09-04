package com.lab3.Spring.boot.service;

import com.lab3.Spring.boot.domain.Post;
import com.lab3.Spring.boot.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;
    @Override
    public Post getPostById(long id) {
        return postRepository.getPostById(id);
    }
    @Override
    public List<Post> getAll() {
        return postRepository.getAll();
    }

    @Override
    public void add(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deleteById(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void update(Post post) {
        postRepository.update(post);
    }
}
