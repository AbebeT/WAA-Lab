package com.lab3.Spring.boot.repository;


import com.lab3.Spring.boot.domain.Post;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    @Modifying
    @Query(value = "update Post set Post.author = :post.getAuthor() where post.getId() = id", nativeQuery = true)
    public List<Post> updatePost(@Param("post")  Post post);




}
