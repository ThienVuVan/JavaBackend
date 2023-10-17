package com.bookstore.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class File {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_id")
	private int fileId;

	@Column(name = "file_name", length = 255, nullable = false)
	private String fileName;

	@Column(name = "file_path", length = 255, nullable = false)
	private String filePath;

	// to book;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "file")
	private Book book;

	public File() {
		super();
		// TODO Auto-generated constructor stub
	}

	public File(int fileId, String fileName, String filePath) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.filePath = filePath;
	}

	public File(String fileName, String filePath) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
