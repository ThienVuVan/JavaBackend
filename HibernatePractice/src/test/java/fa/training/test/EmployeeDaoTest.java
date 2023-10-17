package fa.training.test;


import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import fa.training.daoimpl.EmployeeDaoImpl;
import fa.training.daoimpl.JobDaoImpl;
import fa.training.entities.Employee;
import fa.training.utils.HibernateUtils;

public class EmployeeDaoTest {
	public static JobDaoImpl jobdao;
	public static EmployeeDaoImpl employeedao;

	@Before
	public void setUp() {
		jobdao = new JobDaoImpl();
		employeedao = new EmployeeDaoImpl();
	}

//	@Test
//	public void Test() {
//		//Job job = jobdao.getById("J01");
//		Job job = new Job("J05", "Dev5", 1000, 2000);
//		Employee employee = new Employee("Nguyen", "Vu Van", "ads@gmail.com", "123455", 4343d);
//		employee.setJob(job);
//		//job.getEmployees().add(employee);
//		assertTrue(employeedao.saveorupdate(employee));
//	}

//	@Test
//	public void Test() {
//		Employee employee = new Employee("Dung", "Vu Van", "ads@gmail.com", "123455", 4343d, "");
//		Project pro = new Project("project01", LocalDate.of(2023, 06, 4), LocalDate.of(2024, 1, 1));
//		employee.getProjects().add(pro);
//		assertTrue(employeedao.save(employee));
//	}

//	// test first level cache;
//	@Test
//	public void Test() {
//		Session session = HibernateUtils.getSessionFactory().openSession();
//		Employee em1 = session.get(Employee.class, 1);
//		System.out.println(em1.getFirstName());
//		
//		//session.evict(em1);
//		
//		Employee em2 = session.get(Employee.class, 1);
//		System.out.println(em2.getFirstName());
//		session.close();
//	}
	
	// test second level cache;
	@Test
	public void Test() {
		Session sessionA = HibernateUtils.getSessionFactory().openSession();
		Session sessionB = HibernateUtils.getSessionFactory().openSession();

		Employee employee = sessionA.load(Employee.class, 1);
		System.out.println(employee.getFirstName());

		// Lấy đối tượng employee thêm lần nữa trong sesssionA
		employee = sessionA.load(Employee.class, 1);
		System.out.println(employee.getFirstName());

		// Lấy đối tượng department thêm lần nữa trong sessionB
		employee = sessionB.load(Employee.class, 1);
		System.out.println(employee.getFirstName());
		
		sessionA.close();
		sessionB.close();

	}

}
