package com.jpapractice.repository;

import com.jpapractice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u join fetch u.userDetail where u.id = :id")
    User findUserWithUserDetailById(Integer id);
    @Query("select u from User u join fetch u.courseList where u.id = :id")
    User findUserWithCourses(Integer id);
    @Query("select u from User u join fetch u.houseList where u.id = :id")
    User findUserWithHouses(Integer id);
}
