package com.lab3.Spring.boot.repository;

import com.lab3.Spring.boot.domain.Post;
import com.lab3.Spring.boot.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(
            value = "SELECT * FROM User u WHERE u.id = :id",
            nativeQuery = true)
    public Optional<User> findPostsByUserId(@Param("id") long id);
    public Optional<User> findByUsername(String username);

}
