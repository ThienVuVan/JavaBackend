package com.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }

//    @Component
//    class runner implements CommandLineRunner{
//        private UserRepo userRepo;
//        private PasswordEncoder passwordEncoder;
//
//        runner(UserRepo userRepo, PasswordEncoder passwordEncoder) {
//            this.userRepo = userRepo;
//            this.passwordEncoder = passwordEncoder;
//        }
//
//        @Override
//        public void run(String... args) throws Exception {
//            User user = new User("thien", passwordEncoder.encode("1234"));
//            userRepo.save(user);
//        }
//    }

}
