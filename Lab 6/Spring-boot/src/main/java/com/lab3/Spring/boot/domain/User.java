package com.lab3.Spring.boot.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name="user")
public class User {
    @Id
    private long id;
    private String name;
    @OneToMany(cascade= CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinTable
    private List<Post> posts;

}