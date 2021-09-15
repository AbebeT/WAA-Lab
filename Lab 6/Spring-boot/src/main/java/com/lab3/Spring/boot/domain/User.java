package com.lab3.Spring.boot.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@CrossOrigin(origins = "http://localhost:3000")
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(cascade= CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    @JoinTable
    private List<Post> posts;

}
