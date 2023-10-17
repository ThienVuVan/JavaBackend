package com.in28minute.jpahibernate.springdatajpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minute.jpahibernate.model.Course;

@Component
public class SpringDataJpaRunner implements CommandLineRunner {
	
	@Autowired
	private SpringDataJpaRepo courseSpDataJpa;
	
	@Override
	public void run(String... args) throws Exception {
		courseSpDataJpa.save( new Course(2,"pythoon", "thien"));
		courseSpDataJpa.save( new Course(3,"Java", "thien"));
		courseSpDataJpa.save( new Course(4,"Cpp", "thien"));
		
		//courseJDBC.deleteId(2);
		//System.out.println(courseSpDataJpa.findById(2l));
		//System.out.println(courseSpDataJpa.findAll());
		System.out.println(courseSpDataJpa.findByAuthor("thien"));
		System.out.println(courseSpDataJpa.findByName("Java"));

	}

}
