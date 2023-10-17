package com.in28minute.jpahibernate.jpa;

import org.springframework.stereotype.Repository;

import com.in28minute.jpahibernate.model.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJPA {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	public Course findbyId(long id) {
		return entityManager.find(Course.class, id);
	}
	public void deletebyId(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
}
