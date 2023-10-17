package fa.training.daoimpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.EmployeeDao;
import fa.training.entities.Employee;
import fa.training.utils.HibernateUtils;

public class EmployeeDaoImpl implements EmployeeDao {
	@Override
	public void saveEmployee(Employee employee) {
		try(Session session = HibernateUtils.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
