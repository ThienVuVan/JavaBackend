package fa.training.dao;

import java.util.List;

import fa.training.entities.Employee;


public interface EmployeeDao {
	public void saveEmployee(Employee employee);
	public List<Object[]> findEmployee();
	public List<Employee> findAllEmployee();
	public List<Employee> searchEmployee(Long id_param);
}
