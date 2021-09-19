package com.lab3.Spring.boot.service;

import com.lab3.Spring.boot.domain.Post;
import com.lab3.Spring.boot.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;
    @Override
    public Optional<Post> findById(long id) {
        return postRepository.findById(id);
    }
    @Override
    public List<Post> findAll() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(p->posts.add(p));
        return posts;
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void deletePostById(long id) {
        postRepository.deleteById(id);
    }

//    @Override
//    public void update(Post post) {
//        postRepository.updatePost(post);
//
//    }
}
