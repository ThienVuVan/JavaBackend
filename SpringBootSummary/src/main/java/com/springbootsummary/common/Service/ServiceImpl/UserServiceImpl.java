package com.springbootsummary.common.Service.ServiceImpl;

import com.springbootsummary.BeanUtils;
import com.springbootsummary.common.Repository.AccountRepository;
import com.springbootsummary.common.Repository.RoleRepository;
import com.springbootsummary.common.Service.UserService;
import com.springbootsummary.common.entity.Account;
import com.springbootsummary.common.entity.Role;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    @Override
    public Account retrieveAccountById(int id) {
        return null;
    }
    @Override
    public void test(){
        Account account = new Account("aaaaaab", 20);
        Role role = roleRepository.findById(1).get();
        account.setRole(role);
        accountRepository.save(account);
    }
    // get thi co can transaction khong
    // entitymanager lớn bọc entitymanager con (đã thực thi xong bởi repository và đã đóng)
    // đôi khi ko cần bọc nhưng đầu hết cần bọc lại để đảm bảo các entity dduwjocj quản lý đúng.
    // không được bọc transaction, tức là chưa đc quản lý bởi entitymanager nào cả.
}
