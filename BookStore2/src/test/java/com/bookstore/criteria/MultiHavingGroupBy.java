package com.bookstore.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.bookstore.entities.Book;
import com.bookstore.utils.HibernateUtils;

public class MultiHavingGroupBy {
	public static void main(String[] args) {

		Session session = HibernateUtils.getSessionFactory().openSession();

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);

		Root<Book> root = criteria.from(Book.class);

		criteria.multiselect(builder.count(root.get("bookId")), root.get("title"), root.get("price"));
		criteria.groupBy(root.get("title"));
		criteria.having(builder.between(root.get("price"), 100000, 200000));

		List<Object[]> result = session.createQuery(criteria).getResultList();

		for (Object[] ob : result) {
			System.out.println(ob[0] + " - " + ob[1] + " - " + ob[2]);
		}
		session.close();
	}

}
