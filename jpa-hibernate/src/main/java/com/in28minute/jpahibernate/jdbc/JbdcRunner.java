package com.in28minute.jpahibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minute.jpahibernate.model.Course;

//@Component
//public class JbdcRunner implements CommandLineRunner {
//	
//	@Autowired
//	private CourseJDBC courseJDBC;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		courseJDBC.insert( new Course(2,"pythoon", "thien"));
//		courseJDBC.insert( new Course(3,"Java", "thien"));
//		courseJDBC.insert( new Course(4,"Cpp", "thien"));
//		
//		//courseJDBC.deleteId(2);
//		System.out.println(courseJDBC.selectId(3));
//	}
//
//}
