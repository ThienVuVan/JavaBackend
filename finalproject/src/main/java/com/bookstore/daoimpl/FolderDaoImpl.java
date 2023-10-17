package com.bookstore.daoimpl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bookstore.dao.Dao;
import com.bookstore.entities.Book;
import com.bookstore.entities.Folder;
import com.bookstore.utils.HibernateUtils;

public class FolderDaoImpl implements Dao<Folder> {

	@Override
	public boolean save(Folder folder) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Serializable result = session.save(folder);
			transaction.commit();
			return (result != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Folder folder) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.update(folder);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveorupdate(Folder folder) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(folder);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Folder getById(Object id) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Folder folder = session.get(Folder.class, (Serializable) id);
			transaction.commit();
			System.err.println(folder);
			return folder;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Folder getByName(Object name) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			String hql = "FROM Folder e WHERE e.folderName = :name";
			Folder folder = session.createQuery(hql, Folder.class)
			        .setParameter("name", (Serializable)name)
			        .uniqueResult();
			return folder;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean merge(Folder t) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
