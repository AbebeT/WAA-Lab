package com.lab3.Spring.boot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@CrossOrigin(origins = "http://localhost:3000")
@Entity
@Table(name = "POST")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private String author;
}
