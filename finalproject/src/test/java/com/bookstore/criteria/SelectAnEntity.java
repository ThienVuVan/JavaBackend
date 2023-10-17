package com.bookstore.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

import com.bookstore.entities.Book;
import com.bookstore.utils.HibernateUtils;

public class SelectAnEntity {
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Book> criteria = builder.createQuery(Book.class);
		
		Root<Book> root = criteria.from(Book.class);
		
		criteria = criteria.select(root);
		
		List<Book> books = session.createQuery(criteria).getResultList();
		
		for(Book book : books) {
			System.out.println(book);
		}
		session.close();
	}
}
