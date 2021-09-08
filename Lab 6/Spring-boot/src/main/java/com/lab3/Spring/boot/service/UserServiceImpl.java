package com.lab3.Spring.boot.service;

import com.lab3.Spring.boot.domain.Post;
import com.lab3.Spring.boot.domain.User;
import com.lab3.Spring.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Post> findPostsByUserId(long id) {
        List<Post> posts = new ArrayList<>();
        userRepository.findPostsByUserId(id).orElse(null).getPosts().forEach(p->posts.add(p));
        return posts;
    }
}
