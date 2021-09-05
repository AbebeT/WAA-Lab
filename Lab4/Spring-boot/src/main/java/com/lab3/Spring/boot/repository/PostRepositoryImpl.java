package com.lab3.Spring.boot.repository;

import com.lab3.Spring.boot.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    List<Post> posts = new ArrayList<>(Arrays.asList(
            new Post(1, "Food", "it was delicious", "abebe"),
                    new Post(2, "Movie", "it was awesome", "bethi")
    ));

    @Override
    public Post getPostById(long id) {
        return posts.stream().filter(p->p.getId() == id).findFirst().get();
    }

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public List<Post> save(Post post) {
        posts.add(post);
        return posts;
    }

    @Override
    public List<Post> deleteById(long id) {
        for(int i=0; i< posts.size();i++){
            if(posts.get(i).getId() == id) {
                posts.remove(i);
                return posts;
            }
        }
        return posts;

    }
    @Override
    public void update(Post post) {
        for(int i=0; i< posts.size();i++){
            if(posts.get(i).getId() == post.getId()) {
                posts.set(i, post);
                return;
            }
        }

    }
}
