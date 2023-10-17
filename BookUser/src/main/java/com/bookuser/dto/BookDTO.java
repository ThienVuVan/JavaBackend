package com.bookuser.dto;

import com.bookuser.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private int bookId;
    private String bookName;
    private User user;
    public BookDTO(String bookName) {
        this.bookName = bookName;
    }
}
