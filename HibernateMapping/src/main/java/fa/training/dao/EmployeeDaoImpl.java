package fa.training.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.entities.Employees;
import fa.training.utils.HibernateUtils;

public class EmployeeDaoImpl implements Dao<Employees> {
	@Override
	public boolean save(Employees employee) {
		try (Session session = HibernateUtils.getSessionFactory().openSession();) {
			Transaction transaction = session.beginTransaction();
			Serializable result = session.save(employee);
			System.out.println(result);
			transaction.commit();
			return (result != null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Employees t) {
		// TODO Auto-generated method stub
		return false;
	}
}
