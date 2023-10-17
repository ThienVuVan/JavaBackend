package com.bookstore.criteria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.bookstore.entities.User;
import com.bookstore.utils.HibernateUtils;

public class SelectMultiValue {
	public static void main(String[] args) {
Session session = HibernateUtils.getSessionFactory().openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		
		Root<User> root = criteria.from(User.class);
		
		criteria.multiselect(root.get("userId"), root.get("userName"), root.get("phoneNumber"));
		criteria.where(builder.equal(root.get("userName"), "ThienVuVan"));
		
		List<Object[]> users = session.createQuery(criteria).getResultList();
		
		for(Object[] user : users) {
			System.err.println(user[0] + " - " + user[1] + " - " + user[2]);
		}
		
		session.close();
	}
}
