package com.criteria.daoimpl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.criteria.dao.Dao;
import com.criteria.entities.Favorite;
import com.criteria.entities.Review;
import com.criteria.entities.User;
import com.criteria.utils.HibernateUtils;

public class FavoriteDaoImpl implements Dao<Favorite> {

	@Override
	public boolean save(Favorite favorite) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Serializable result = session.save(favorite);
			transaction.commit();
			return (result != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Favorite favorite) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(favorite);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean merge(Favorite favorite) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.merge(favorite);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveorupdate(Favorite favorite) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(favorite);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Favorite getById(Object id) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Favorite favorite = session.get(Favorite.class, (Serializable)id);
			System.out.println(favorite);
			transaction.commit();
			return favorite;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
