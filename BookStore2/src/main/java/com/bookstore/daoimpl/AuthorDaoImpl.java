package com.bookstore.daoimpl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bookstore.dao.Dao;
import com.bookstore.entities.Author;
import com.bookstore.entities.Tag;
import com.bookstore.entities.User;
import com.bookstore.utils.HibernateUtils;

public class AuthorDaoImpl implements Dao<Author> {

	@Override
	public boolean save(Author author) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Serializable result = session.save(author);
			transaction.commit();
			return (result != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Author author) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(author);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveorupdate(Author author) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(author);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Author getById(Object id) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Author author = session.get(Author.class, (Serializable)id);
			System.out.println(author);
			transaction.commit();
			return author;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean merge(Author t) {
		// TODO Auto-generated method stub
		return false;
	}

}
