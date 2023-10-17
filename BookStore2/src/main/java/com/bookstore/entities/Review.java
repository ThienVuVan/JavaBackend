package com.bookstore.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private int reviewId;
	
	// to user;
	@ManyToOne()
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
	
	// to book;
	@ManyToOne()
	@JoinColumn(name = "book_id", referencedColumnName = "book_id")
	private Book book;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "rating")
	private int rating;

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(String comment, int rating) {
		super();
		this.comment = comment;
		this.rating = rating;
	}

	public Review(User user, Book book, String comment, int rating) {
		super();
		this.user = user;
		this.book = book;
		this.comment = comment;
		this.rating = rating;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
//	@Override
//    public int hashCode(){
//		 final int prime = 31;
//		    int result = 1;
//		    result = prime * result + ((user == null) ? 0 : user.hashCode());
//		    result = prime * result + ((book == null) ? 0 : book.hashCode());
//		    return result;
//	}
//
//    @Override
//    public boolean equals(Object obj) {
//    	if (this == obj) {
//            return true;
//        }
//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }
//        Review other = (Review) obj;
//        if (user == null) {
//            if (other.user != null) {
//                return false;
//            }
//        } else if (!user.equals(other.user)) {
//            return false;
//        }
//        if (book == null) {
//            if (other.book != null) {
//                return false;
//            }
//        } else if (!book.equals(other.book)) {
//            return false;
//        }
//        return true;
//    }
	
}
