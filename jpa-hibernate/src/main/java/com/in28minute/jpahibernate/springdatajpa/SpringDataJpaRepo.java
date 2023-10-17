package com.in28minute.jpahibernate.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minute.jpahibernate.model.Course;

import java.util.List;

public interface SpringDataJpaRepo extends JpaRepository<Course, Long> {
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);


}
