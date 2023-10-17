package com.jpapractice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_author")
public class BookAuthor{
//    // Both is @Id;
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "book_id")
//    private Book book;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "publisher_id")
//    private Author author;

    // Using composite key
    @EmbeddedId
    private BookAuthorId id;
    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @MapsId("authorId")
    @JoinColumn(name = "author_id")
    private Author author;
}
