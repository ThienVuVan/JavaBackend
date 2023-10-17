package com.jwtsecurity.repository;

import com.jwtsecurity.entity.Role;
import com.jwtsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    @Query("SELECT u.roles FROM User u WHERE u.email = :email")
    List<Role> findRolesByEmail(String email);
}
