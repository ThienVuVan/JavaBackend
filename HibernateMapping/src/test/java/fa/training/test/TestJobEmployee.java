package fa.training.test;

import java.time.LocalDate;

import fa.training.dao.EmployeeDao;
import fa.training.dao.EmployeeDaoImpl;
import fa.training.entities.Employees;
import fa.training.entities.Jobs;

public class TestJobEmployee {
	public static void main(String[] args) {
		EmployeeDao<Employees> employeeDao = new EmployeeDaoImpl();
		Jobs job = new Jobs("J03", "Java Dev2", 1000, 2000);
		Employees employee = new Employees("Tran", "Quang Anh","anhtt22@fsoft.com.vn", "0988777346", LocalDate.of(2019, 1, 1), 1000, 1.1);
		employee.setJob(job);
		employeeDao.save(employee);
	}
}
