package com.springbootsummary;

import com.springbootsummary.common.Repository.AccountRepository;
import com.springbootsummary.common.Repository.RoleRepository;
import com.springbootsummary.common.entity.Account;
import com.springbootsummary.common.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

public class MyThread implements Runnable{
    private RoleRepository roleRepository;
    private AccountRepository accountRepository;
    public MyThread() {
        roleRepository = BeanUtils.getBean(RoleRepository.class);
        accountRepository = BeanUtils.getBean(AccountRepository.class);
    }
    @Override
    public void run() {
//        addRold();
        addUserWithRole();

    }
    public void addRold(){
        // add data to role
        roleRepository.save(new Role(1, "ROLE_USER"));
        roleRepository.save(new Role(2, "ROLE_ADMIN"));
    }
    public void addUserWithRole(){
        Account account = new Account("aaaaaab", 20);
        Role role = roleRepository.findById(1).get();
        EntityManager entityManager = BeanUtils.getBean(EntityManager.class);
        entityManager.refresh(role);
        account.setRole(role);
        accountRepository.save(account);
    }
}
