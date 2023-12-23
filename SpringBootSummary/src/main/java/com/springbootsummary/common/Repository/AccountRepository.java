package com.springbootsummary.common.Repository;

import com.springbootsummary.common.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
