package com.springdatajpa.repository;

import com.springdatajpa.model.User;
import com.springdatajpa.repository.custom.UserCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {
    List<User> findByUsername(String username);

    void deleteByUsername(String username);

    @Query("select u from User u where u.password = ?1")
    List<User> findPassword(String password);
}
