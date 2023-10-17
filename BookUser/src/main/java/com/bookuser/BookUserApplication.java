package com.bookuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class BookUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookUserApplication.class, args);
    }

}
