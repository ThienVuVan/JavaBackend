package com.jpapractice.repository;

import com.jpapractice.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer> {
    UserDetail findUserDetailByUserId(Integer id);
}
