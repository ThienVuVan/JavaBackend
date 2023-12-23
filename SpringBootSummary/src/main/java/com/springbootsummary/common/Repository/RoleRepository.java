package com.springbootsummary.common.Repository;

import com.springbootsummary.common.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
