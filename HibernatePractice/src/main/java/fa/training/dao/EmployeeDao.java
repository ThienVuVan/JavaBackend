package fa.training.dao;

import java.util.List;

import fa.training.entities.Employee;


public interface EmployeeDao {
	public boolean save(Employee employee);
	public boolean saveorupdate(Employee employee);
	public List<Object[]> find();
	public List<Employee> findAll();
	public List<Employee> search(Long id_param);
	public Employee getById(int id);
}
