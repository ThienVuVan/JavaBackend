//package com.jpapractice.model;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "book_author")
//public class Book_Author {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//
//    @ManyToOne
//    @JoinColumn(name = "book_id")
//    Book book;
//
//    @ManyToOne
//    @JoinColumn(name = "author_id")
//    Author author;
//}
