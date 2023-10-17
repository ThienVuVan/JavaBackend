package fa.training.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.training.dao.CourseDAO;
import fa.training.models.Course;
import fa.training.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	// Dependency inject the CourseDAO
	@Autowired
	private CourseDAO courseDAO;

	@Override
	@Transactional
	public List<Course> getCourses() {
		return courseDAO.getCourses();
	}

	@Override
	@Transactional
	public void saveCourse(Course theCourse) {
		courseDAO.saveCourse(theCourse);

	}

	@Override
	@Transactional
	public Course getCourse(String theId) {
		return courseDAO.getCourse(theId);
	}

	@Override
	@Transactional
	public void deleteCourse(String theId) {
		courseDAO.deleteCourse(theId);
	}

}
