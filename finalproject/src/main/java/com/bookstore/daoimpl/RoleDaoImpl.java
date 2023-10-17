package com.bookstore.daoimpl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bookstore.dao.Dao;
import com.bookstore.entities.Role;
import com.bookstore.utils.HibernateUtils;

public class RoleDaoImpl implements Dao<Role> {

	@Override
	public boolean save(Role role) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Serializable result = session.save(role);
			transaction.commit();
			return (result != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Role t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveorupdate(Role role) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(role);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Role getById(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean merge(Role t) {
		// TODO Auto-generated method stub
		return false;
	}

}
