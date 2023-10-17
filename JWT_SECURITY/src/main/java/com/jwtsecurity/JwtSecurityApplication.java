package com.jwtsecurity;

import com.jwtsecurity.entity.User;
import com.jwtsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@SpringBootApplication
public class JwtSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtSecurityApplication.class, args);
    }
    @Component
    public class ApplicationRunner implements CommandLineRunner {
        private final UserService service;
        private PasswordEncoder passwordEncoder;
        @Autowired
        public ApplicationRunner(UserService service, PasswordEncoder passwordEncoder){
            this.service = service;
            this.passwordEncoder = passwordEncoder;
        }
        @Override
        public void run(String... args) throws Exception {
//            Optional<User> user = userRepository.findByEmail("thienvuvan@gmail.com");
//            List<Role> roles = userRepository.findRolesByEmail("thienvuvan@gmail.com");
//            System.out.println(user.get());
//            System.out.println(roles);
            //insertData();
        }
        public void insertData(){
//            userService.saveRole(new Role(null,"ROLE_USER"));
//            userService.saveRole(new Role(null,"ROLE_MANAGER"));
//            userService.saveRole(new Role(null,"ROLE_ADMIN"));
//            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

            service.saveUser(new User(null,"thienvuvan","thienvuvan@gmail.com", passwordEncoder.encode("1234"), new HashSet<>()));
//            userService.saveUser(new User(null,"thinhvuxuan","thinhvuxuan@gmail.com","6789",new HashSet<>()));

//            userService.addToUser("thienvuvan@gmail.com", "ROLE_USER");
//            userService.addToUser("thienvuvan@gmail.com", "ROLE_MANAGER");
//
//            userService.addToUser("thinhvuxuan@gmail.com", "ROLE_ADMIN");
//            userService.addToUser("thinhvuxuan@gmail.com", "ROLE_SUPER_ADMIN");
        }

    }

}
