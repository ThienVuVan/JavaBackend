package com.bookstore.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "folders")
public class Folder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "folder_id")
	private int folderId;

	@Column(name = "folder_name", length = 255, nullable = false)
	private String folderName;

	@Column(name = "folder_path", length = 255, nullable = false)
	private String folderPath;

	// to user;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	// to book;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "folder")
	private Set<Book> books = new HashSet<Book>();

	public Folder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Folder(String folderName, String folderPath) {
		super();
		this.folderName = folderName;
		this.folderPath = folderPath;
	}

	public Folder(int folderId, String folderName, String folderPath) {
		super();
		this.folderId = folderId;
		this.folderName = folderName;
		this.folderPath = folderPath;
	}

	@Override
	public String toString() {
		return "Folder [folderId=" + folderId + ", folderName=" + folderName + ", folderPath=" + folderPath + "]";
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public int getFolderId() {
		return folderId;
	}

	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getFolderPath() {
		return folderPath;
	}

	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
