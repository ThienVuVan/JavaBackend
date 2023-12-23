package com.springbootsummary;

import com.springbootsummary.common.Repository.AccountRepository;
import com.springbootsummary.common.Repository.RoleRepository;
import com.springbootsummary.common.entity.Account;
import com.springbootsummary.common.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class test {
    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;
//    @Transactional
    public void run(){
        Account account = new Account("aaaaaab", 20);
        Role role = roleRepository.findById(1).get();
        account.setRole(role);
        accountRepository.save(account);
    }
}
