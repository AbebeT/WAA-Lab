package com.lab3.Spring.boot.service;

import com.lab3.Spring.boot.domain.Post;
import com.lab3.Spring.boot.domain.PostV2;
import com.lab3.Spring.boot.repository.PostRepository;
import com.lab3.Spring.boot.repository.PostRepositoryV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceV2Impl implements PostServiceV2 {

    @Autowired
    PostRepositoryV2 postRepositoryV2;
    @Override
    public PostV2 getPostById(long id) {
        return postRepositoryV2.getPostById(id);
    }
    @Override
    public List<PostV2> getAll() {
        return postRepositoryV2.getAll();
    }

    @Override
    public List<PostV2> add(PostV2 post) {
        return postRepositoryV2.save(post);

    }

    @Override
    public List<PostV2> deleteById(long id) {
        return postRepositoryV2.deleteById(id);
    }

    @Override
    public void update(PostV2 post, long id) {
        postRepositoryV2.update(post);
    }
}
