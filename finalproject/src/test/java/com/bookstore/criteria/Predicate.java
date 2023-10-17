package com.bookstore.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.bookstore.entities.User;
import com.bookstore.utils.HibernateUtils;

public class Predicate {
	public static void main(String[] args) {
		Session session = HibernateUtils.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> criteria = builder.createQuery(User.class);
		Root<User> root = criteria.from(User.class);
		criteria = criteria.select(root);
		javax.persistence.criteria.Predicate p1 = builder.like(root.get("userName"), "%T%");
		javax.persistence.criteria.Predicate p2 = builder.equal(root.get("userId"), "user02");
		criteria.where(builder.or(p1,p2));
		List<User> users = session.createQuery(criteria).getResultList();
		for(User user : users) {
			System.out.println(user);
		}
		session.close();
	}
}
