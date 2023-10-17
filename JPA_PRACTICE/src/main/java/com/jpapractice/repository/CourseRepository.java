package com.jpapractice.repository;

import com.jpapractice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findCourseByUserId(Integer id);
    @Query("select c from Course c where c.user.id = :id")
    List<Course> findCourseByUserIdQuery(Integer id);
}
