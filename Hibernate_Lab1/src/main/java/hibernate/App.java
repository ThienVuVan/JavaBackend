package hibernate;
import fa.training.dao.EmployeeDao;
import fa.training.daoimpl.EmployeeDaoImpl;
import fa.training.entities.Employee;
import fa.training.entities.Project;

public class App {
	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDaoImpl();

		Employee employee = new Employee();
		employee.setFirstName("Anna");
		employee.setLastName("Hook");

		Project project1 = new Project();
		project1.setTitle("Employee Management System");

		Project project2 = new Project();
		project2.setTitle("Content Management System");

		employee.getProjects().add(project1);
		employee.getProjects().add(project2);

		project1.getEmployees().add(employee);
		project2.getEmployees().add(employee);

		employeeDao.saveEmployee(employee);
	}
}
