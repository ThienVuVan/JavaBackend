package fa.training.dao;

import java.util.List;

import fa.training.models.Student;

public interface StudentDAO {
	public List<Student> getStudents();

	public void saveStudent(Student theStudent);

	public Student getStudent(String theId);

	public void deleteStudent(String theId);

}
