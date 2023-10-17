package fa.training.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.JobDao;
import fa.training.dao.JobDetailDao;
import fa.training.entities.Employee;
import fa.training.entities.Job;
import fa.training.entities.JobDetail;
import fa.training.utils.HibernateUtils;

public class JobDetailDaoImpl implements JobDetailDao {

	@Override
	public boolean find() {
		return false;
	}

	@Override
	public boolean save(JobDetail jobdetail) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(jobdetail);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveorupdate(JobDetail jobdetail) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(jobdetail);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public JobDetail getById(int id) {
		try(Session session = HibernateUtils.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			JobDetail jobdetail = session.get(JobDetail.class, (Serializable)id);
			transaction.commit();
			return jobdetail;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
