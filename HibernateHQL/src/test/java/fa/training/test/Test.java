package fa.training.test;

import java.util.List;

import fa.training.dao.EmployeeDao;
import fa.training.daoimpl.EmployeeDaoImpl;
import fa.training.entities.Employee;
import fa.training.entities.Project;

public class Test {
	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();
//		List<Object[]> objects = employeeDao.findEmployee();
		//List<Employee> objects = employeeDao.searchEmployee(1L);
		List<Employee> objects = employeeDao.findAllEmployee();

		for (Employee object : objects) {
			System.out.println(object.toString());
		}
//		
//		for (Object[] object : objects) {
//			System.out.println(((Employee)object[0]).toString());
//			System.out.println(((Project)object[0]).toString());
//		}
	}
}
