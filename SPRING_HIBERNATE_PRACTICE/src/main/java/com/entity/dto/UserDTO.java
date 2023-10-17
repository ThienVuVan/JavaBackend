package com.entity.dto;

import java.util.HashSet;
import java.util.Set;

import com.entity.Book;

public class UserDTO {

	private int userId;

	private String userName;

	private String password;

	private Set<Book> books = new HashSet<Book>();

	public UserDTO() {
	}

	public UserDTO(int userId, String userName, String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public UserDTO(int userId, String userName, String password, Set<Book> books) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.books = books;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", password=" + password + "]";
	}

}
