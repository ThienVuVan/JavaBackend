package com.in28minute.jpahibernate.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minute.jpahibernate.model.Course;

@Component
public class JpaRunner implements CommandLineRunner {

	@Autowired
	private CourseJPA courseJPA;

	@Override
	public void run(String... args) throws Exception {
		courseJPA.insert( new Course(2,"pythoon", "thien"));
		courseJPA.insert( new Course(3,"Java", "thien"));
		courseJPA.insert( new Course(4,"Cpp", "thien"));

		//courseJDBC.deleteId(2);
		System.out.println(courseJPA.findbyId(3));
	}

}
