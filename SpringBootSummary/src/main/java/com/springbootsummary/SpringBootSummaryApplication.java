package com.springbootsummary;

import com.springbootsummary.common.Repository.AccountRepository;
import com.springbootsummary.common.Repository.RoleRepository;
import com.springbootsummary.common.entity.Account;
import com.springbootsummary.common.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class SpringBootSummaryApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSummaryApplication.class, args);
//        test one = BeanUtils.getBean(test.class);
//        one.run();
    }
}

