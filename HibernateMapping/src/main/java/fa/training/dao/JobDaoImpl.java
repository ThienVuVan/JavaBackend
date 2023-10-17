package fa.training.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities.Jobs;
import fa.training.utils.HibernateUtils;

public class JobDaoImpl implements Dao<Jobs> {

	public boolean save(Jobs job) {
		try (Session session = HibernateUtils.getSessionFactory().openSession();) {
			Transaction transaction = session.beginTransaction();
			Serializable result = session.save(job);
			System.out.println(result);
			transaction.commit();
			return (result != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean update(Jobs t) {
		// TODO Auto-generated method stub
		return false;
	}
}
