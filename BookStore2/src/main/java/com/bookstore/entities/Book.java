package com.bookstore.entities;

import java.time.LocalDate;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.procedure.spi.ParameterStrategy;

@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int bookId;

	@Column(name = "title", length = 255, nullable = false, unique = true)
	private String title;

	@Column(name = "price", precision = 11, scale = 2)
	private Double price;

	@Column(name = "publish_year")
	private LocalDate publishYear;

	@Column(name = "offline_url", length = 255, nullable = true, unique = true)
	private String offlineURL;

	// to user;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;

	// to file;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "file_id", referencedColumnName = "file_id")
	private File file;

	// to folder;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "folder_id", referencedColumnName = "folder_id")
	private Folder folder;

	// to tag;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "book_tag", joinColumns = {
			@JoinColumn(referencedColumnName = "book_id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "tag_id") })
	private Set<Tag> tags = new HashSet<Tag>();

	// to author
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "book_author", joinColumns = {
			@JoinColumn(referencedColumnName = "book_id") }, inverseJoinColumns = {
					@JoinColumn(referencedColumnName = "author_id") })
	private Set<Author> authors = new HashSet<Author>();

	// to review;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
	private Set<Review> review = new HashSet<Review>();

	// to favortie;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
	private Set<Favorite> favorite = new HashSet<Favorite>();

	public Book() {
		super();
	}

	public Book(String title, Double price, LocalDate publishYear, String offlineURL) {
		super();
		this.title = title;
		this.price = price;
		this.publishYear = publishYear;
		this.offlineURL = offlineURL;
	}

	public Book(int bookId, String title, Double price, LocalDate publishYear, String offlineURL) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.publishYear = publishYear;
		this.offlineURL = offlineURL;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", publishYear=" + publishYear
				+ ", offlineURL=" + offlineURL + "]";
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDate getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(LocalDate publishYear) {
		this.publishYear = publishYear;
	}

	public String getOfflineURL() {
		return offlineURL;
	}

	public void setOfflineURL(String offlineURL) {
		this.offlineURL = offlineURL;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Set<Review> getReview() {
		return review;
	}

	public void setReview(Set<Review> review) {
		this.review = review;
	}

	public Set<Favorite> getFavorite() {
		return favorite;
	}

	public void setFavorite(Set<Favorite> favorite) {
		this.favorite = favorite;
	}

}
