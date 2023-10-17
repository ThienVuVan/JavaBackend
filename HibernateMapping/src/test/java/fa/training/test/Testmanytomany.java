package fa.training.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fa.training.dao.Dao;
import fa.training.dao.EmployeeDaoImpl;
import fa.training.entities.Employees;
import fa.training.entities.Projects;

public class Testmanytomany {
	public static void main(String[] args) {
		Dao<Employees> dao = new EmployeeDaoImpl();
		Employees employee = new Employees("Nguyen", "Dang Khoa",
                "khoadk@fsoft.com.vn", "0988777665", LocalDate.of(2019, 1, 1), 1000, 1.1);
        
        Projects project = new Projects("IT Fundamental", LocalDate.of(2020, 10, 1),
                "Fsoft Academey It Fundamental Training Program", LocalDate.of(2020, 12, 31));
        
        Set<Employees> employees = new HashSet<>();
        employees.add(employee);
        
        Set<Projects> projects = new HashSet<>();
        projects.add(project);
        
        project.setEmployees(employees);
        employee.setProjects(projects);
        dao.save(employee);
	}
}
