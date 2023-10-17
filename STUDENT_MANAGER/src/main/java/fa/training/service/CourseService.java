package fa.training.service;

import java.util.List;

import fa.training.models.Course;

public interface CourseService {
	public List<Course> getCourses();

	public void saveCourse(Course theCourse);

	public Course getCourse(String theId);

	public void deleteCourse(String theId);

}
