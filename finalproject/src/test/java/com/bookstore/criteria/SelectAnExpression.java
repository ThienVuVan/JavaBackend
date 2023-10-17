package com.bookstore.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.bookstore.entities.Book;
import com.bookstore.utils.HibernateUtils;

public class SelectAnExpression {

	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		
		Root<Book> root = criteria.from(Book.class);
		
		criteria.multiselect(root.get("bookId"), root.get("title"));
		
		List<Object[]> books = session.createQuery(criteria).getResultList();
		
		for(Object[] book : books) {
			System.out.println(book[0] + " - " + book[1]);
		}
		session.close();
	}

}
