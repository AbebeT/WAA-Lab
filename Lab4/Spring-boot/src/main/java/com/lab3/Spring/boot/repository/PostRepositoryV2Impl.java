package com.lab3.Spring.boot.repository;

import com.lab3.Spring.boot.domain.Post;
import com.lab3.Spring.boot.domain.PostV2;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepositoryV2Impl implements PostRepositoryV2{

    List<PostV2> posts = new ArrayList<>(Arrays.asList(
            new PostV2(1, "Food", "it was delicious"),
            new PostV2(2, "Movie", "it was awesome")
    ));
    @Override
    public PostV2 getPostById(long id) {
        return posts.stream().filter(p->p.getId() == id).findFirst().get();
    }

    @Override
    public List<PostV2> getAll() {
        return posts;
    }

    @Override
    public List<PostV2> save(PostV2 post) {
        posts.add(post);
        return posts;
    }

    @Override
    public List<PostV2> deleteById(long id) {
        for(int i=0; i< posts.size();i++){
            if(posts.get(i).getId() == id) {
                posts.remove(i);
                return posts;
            }
        }
        return posts;

    }

    @Override
    public void update(PostV2 post) {
        for(int i=0; i< posts.size();i++){
            if(posts.get(i).getId() == post.getId()) {
                posts.set(i, post);
                return;
            }
        }

    }


}
