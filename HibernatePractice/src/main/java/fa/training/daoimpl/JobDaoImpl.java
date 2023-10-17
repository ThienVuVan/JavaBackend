package fa.training.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.JobDao;
import fa.training.entities.Employee;
import fa.training.entities.Job;
import fa.training.utils.HibernateUtils;

public class JobDaoImpl implements JobDao {

	@Override
	public boolean find() {
		return false;
	}

	@Override
	public boolean save(Job job) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(job);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveorupdate(Job job) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(job);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Job getById(String id) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			Job job = session.get(Job.class, id);
			transaction.commit();
			return job;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
