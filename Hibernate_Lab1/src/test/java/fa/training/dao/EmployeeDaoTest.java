//package fa.training.dao;
//
//import fa.training.entities.Employee;
//import fa.training.entities.Project;
//
//public class EmployeeDaoTest {
//	@Autowired
//    EmployeeDao employeeDao;
// 
//    @Test
//    public void saveEmployeeTest() {
//        // INPUT
//        // Create an employee
//        Employee employee = new Employee();
//        employee.setFirstName("Anna");
//        employee.setLastName("Hook");
//
//        // Create a project
//        project project1 = new Project();
//        project.setTitle("Employee Management System");
//
//        // Create other project
//        project project2 = new Project();
//        project1.setTitle("Content Management System");
//
//        // ★Employee can work on 2 projects, add project references into it
//        employee.getProjects().add(project1);
//        employee.getProjects().add(project2);
//
//        // Add employee reference in the projects
//        project1.getEmployees().add(employee);
//        project2.getEmployees().add(employee); 
//        
//        // PROCCESS
//        // Call DAO to save the Employee and Project
//        employeeDao.saveEmployee(employee);
//
//
//        // VERIFY
//        //Employee employeeOut = employeeDao.getEmployeeWithName("Anna");
//        // ↑getEmployeeWithName method must implemented in DAO
//
//        Assert.assertNotNull(employee);
//        Assert.assertEquals("Hook", employeeOut.getLastName());
//        Assert.assertEquals(2, employeeOut.getProjects().size());
//    }
//
//}
