package com.entity.dto;

import com.entity.User;

public class BookDTO {
	private int bookId;
	private String bookName;
	private User user;

	public BookDTO() {
	}

	public BookDTO(String bookName) {
		this.bookName = bookName;
	}

	public User getUser() {
		return user;
	}

	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	@Override
	public String toString() {
		return "BookDTO [bookId=" + bookId + ", bookName=" + bookName + "]";
	}
}
