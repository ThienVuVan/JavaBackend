package fa.training.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities.Jobs;
import fa.training.utils.HibernateUtils;

public class JobDaolmpl implements JobDao<Jobs> {

	public boolean save(Jobs job) {
		try(Session session = HibernateUtils.getSessionFactory().openSession();) {
			Transaction transaction = session.beginTransaction();
			Serializable result = session.save(job);
			transaction.commit();
			return (result != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
