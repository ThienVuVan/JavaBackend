package com.jpapractice.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

//    @OneToMany(mappedBy = "book")
//    private Set<Book_Author> bookAuthorSet;

    @OneToMany(mappedBy = "book")
    private Set<BookAuthor> bookAuthor;
}
