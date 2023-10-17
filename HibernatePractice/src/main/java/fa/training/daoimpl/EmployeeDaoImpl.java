package fa.training.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fa.training.dao.EmployeeDao;
import fa.training.entities.Employee;
import fa.training.utils.HibernateUtils;

public class EmployeeDaoImpl implements EmployeeDao {
	@Override
	public boolean save(Employee employee) {
		try (Session session = HibernateUtils.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			session.save(employee);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Object[]> find() {
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
	public List<Employee> search(Long id_param) {
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
	public List<Employee> findAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession();) {
			Transaction transaction = session.beginTransaction();
			Query query = session.getNamedQuery("FindAllEmployee");
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean saveorupdate(Employee employee) {
		try (Session session = HibernateUtils.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(employee);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee getById(int id) {
		try (Session session = HibernateUtils.getSessionFactory().getCurrentSession()) {
			Transaction transaction = session.beginTransaction();
			Employee employee = session.get(Employee.class, (Serializable) id);
			transaction.commit();
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
