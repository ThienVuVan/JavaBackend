package fa.training.daoimpl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.EmployeeDao;
import fa.training.entities.Employee;
import fa.training.utils.HibernateUtils;

public class EmployeeDaoImpl implements EmployeeDao {
	@Override
	public void saveEmployee(Employee employee) {
		try (Session session = HibernateUtils.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Object[]> findEmployee() {
		try (Session session = HibernateUtils.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction(); // must open transaction;
			String joinQuery = "FROM Employee p JOIN p.projects pd";
			Query query = session.createQuery(joinQuery);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> searchEmployee(Long id_param) {
		try (Session session = HibernateUtils.getSessionFactory().openSession();) {
			Transaction transaction = session.beginTransaction();
			String hql = "FROM Employee p WHERE p.employeeId = :id_param";
			Query query = session.createQuery(hql);
			query.setParameter("id_param", id_param);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Employee> findAllEmployee() {
		try (Session session = HibernateUtils.getSessionFactory().openSession();) {
			Transaction transaction = session.beginTransaction();
			Query query = session.getNamedQuery("FindAllEmployee");
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
