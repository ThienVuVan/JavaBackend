package com.bookstore.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.bookstore.entities.Book;
import com.bookstore.entities.User;
import com.bookstore.utils.HibernateUtils;

public class Join {
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		
		Root<User> uroot = criteria.from(User.class);
		Root<Book> broot = criteria.from(Book.class);
		
		criteria.multiselect(uroot,broot);
		criteria.where(builder.equal(uroot.get("userId"), broot.get("user")));
		
		List<Object[]> result = session.createQuery(criteria).getResultList();
		
		for(Object[] ob : result) {
			System.out.println((User) ob[0]);
			System.out.println((Book) ob[1]);
		}
	}
}
