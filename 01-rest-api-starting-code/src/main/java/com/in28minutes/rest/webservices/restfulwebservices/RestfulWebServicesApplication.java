package com.in28minutes.rest.webservices.restfulwebservices;

import com.in28minutes.rest.webservices.restfulwebservices.model.User;
import com.in28minutes.rest.webservices.restfulwebservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulWebServicesApplication {
	@Bean
	public WebMvcConfigurer mvcConfigurer(){
		// Cross Origin Request
		// http://localhost:3000/ to 8080
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("*")
						.allowedOrigins("http://localhost:3000");
			}
		};

	}
	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
//	@Component
//	class Runner implements CommandLineRunner{
//		private PasswordEncoder passwordEncoder;
//		private UserRepository userRepository;
//		@Autowired
//		public Runner(PasswordEncoder passwordEncoder, UserRepository userRepository) {
//			this.passwordEncoder = passwordEncoder;
//			this.userRepository = userRepository;
//		}
//		@Override
//		public void run(String... args) throws Exception {
//			User user = new User(null, "thienvuvan", "1234");
//			user.setPassword(passwordEncoder.encode(user.getPassword()));
//			userRepository.save(user);
//		}
//	}

}
