package fa.training.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.training.dao.StudentDAO;
import fa.training.models.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

	// Dependency inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Student> getStudents() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query select * form Student
		Query<Student> theQuery = currentSession.createQuery("from Student", Student.class);
		// execute query and get result list
		List<Student> Students = theQuery.getResultList();
		// return the results
		return Students;
	}

	@Override
	public void saveStudent(Student theStudent) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save/upate the Students
		currentSession.saveOrUpdate(theStudent);
	}

	@Override
	public Student getStudent(String theId) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// now retrieve/read from database using the primary key
		Student tempStudent = currentSession.get(Student.class, theId);
		// return the student
		return tempStudent;
	}

	@Override
	public void deleteStudent(String theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// delete student with primary key
		Query theQuery = currentSession.createQuery("delete from Student where id=:studentId");
		theQuery.setParameter("studentId", theId);
		// execute query
		theQuery.executeUpdate();
	}

}
