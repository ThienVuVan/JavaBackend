package com.jpapractice.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "author")
//    private Set<Book_Author> bookAuthorSet;

    @OneToMany(mappedBy = "author")
    private Set<BookAuthor> bookAuthor;
}
