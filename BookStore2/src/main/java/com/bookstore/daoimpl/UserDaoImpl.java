package com.bookstore.daoimpl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bookstore.dao.Dao;
import com.bookstore.entities.User;
import com.bookstore.utils.HibernateUtils;

public class UserDaoImpl implements Dao<User> {

	@Override
	public boolean save(User user) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Serializable result = session.save(user);
			transaction.commit();
			return (result != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(User user) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean merge(User user) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.merge(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveorupdate(User user) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getById(Object id) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			User user = session.get(User.class, (String)id);
			System.out.println(user);
			transaction.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
