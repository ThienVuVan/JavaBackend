package com.jpapractice.repository;

import com.jpapractice.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Integer> {
    @Query("select h from House h join h.userList u where u.id = :id")
    List<House> findHouseByUserId(Integer id);
}
