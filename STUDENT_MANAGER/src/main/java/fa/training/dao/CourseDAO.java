package fa.training.dao;

import java.util.List;

import fa.training.models.Course;

public interface CourseDAO {
	public List<Course> getCourses();

	public void saveCourse(Course theCourse);

	public Course getCourse(String theId);

	public void deleteCourse(String theId);

}
