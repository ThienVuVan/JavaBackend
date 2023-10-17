package com.jpapractice;

import com.jpapractice.model.House;
import com.jpapractice.model.User;
import com.jpapractice.repository.CourseRepository;
import com.jpapractice.repository.HouseRepository;
import com.jpapractice.repository.UserDetailRepository;
import com.jpapractice.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaPracticeApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaPracticeApplication.class, args);
    }
    @Component
    public class runner implements CommandLineRunner{
        private UserRepository userRepository;
        private CourseRepository courseRepository;
        private UserDetailRepository userDetailRepository;
        private HouseRepository houseRepository;
        public runner(UserRepository userRepository, CourseRepository courseRepository, UserDetailRepository userDetailRepository, HouseRepository houseRepository) {
            this.userRepository = userRepository;
            this.courseRepository = courseRepository;
            this.userDetailRepository = userDetailRepository;
            this.houseRepository = houseRepository;
        }
        @Override
        public void run(String... args) throws Exception {
//            TestUserAndUserDetail();
//            TestUserCourse();
            TestUserHouse();
        }
        public void TestUserAndUserDetail(){
//            // Insert Data;
//            User user = new User("ThienVuVan");
//            UserDetail userDetail = new UserDetail("@gmail.com","NinhBinh");
//            user.setUserDetail(userDetail);
//            userRepository.save(user);

//            // EAGER Loading;
//            Optional<User> user = userRepository.findById(1);
//            System.out.println(user.get());
//            System.out.println(user.get().getUserDetail());

//            // LAZY LOADING -> Using Join Fetch
//            User user = userRepository.findUserWithUserDetailById(1);
//            System.out.println(user);
//            System.out.println(user.getUserDetail());

//            // Using Feature of BiDirectional Association;
//            Optional<User> user = userRepository.findById(1);
//            UserDetail userDetail = userDetailRepository.findUserDetailByUserId(1);
//            System.out.println(user);
//            System.out.println(userDetail);
        }
        public void TestUserCourse(){
//            // Insert Data;
//            User user = new User("ThinhVuXuan");
//            Course course1 = new Course("Java");
//            Course course2 = new Course("PHP");
//            user.add(course1);
//            user.add(course2);
//            userRepository.save(user);

//            // EAGER Loading; -> set to EAGER
//            Optional<User> user = userRepository.findById(2);
//            System.out.println(user.get());
//            System.out.println(user.get().getCourseList());

//            // Join Fetch
//            User user = userRepository.findUserWithCourses(2);
//            System.out.println(user);
//            System.out.println(user.getCourseList());

//            // Using Feature BiDirectional Association;
//            Optional<User> user = userRepository.findById(2);
//            List<Course> courseList = courseRepository.findCourseByUserId(2);
//            List<Course> courseList = courseRepository.findCourseByUserIdQuery(2);
//            System.out.println(user.get());
//            System.out.println(courseList);
        }
        public void TestUserHouse(){
//            // Insert Data
//            User user = new User("DungVuVan");
//            House house = new House("house1");
//            user.addHouse(house);
//            userRepository.save(user);

            // Update Data
            Optional<User> user = userRepository.findById(2);
            Optional<House> house = houseRepository.findById(1);
            user.get().addHouse(house.get());
            userRepository.save(user.get());

//            // EAGER Loading User -> set FetchType.EAGER
//            Optional<User> user = userRepository.findById(4);
//            System.out.println(user.get());
//            System.out.println(user.get().getHouseList());

//            // EAGER Loading House -> set FetchType.EAGER
//            Optional<House> house = houseRepository.findById(1);
//            System.out.println(house.get());
//            System.out.println(house.get().getUserList());

//            // Join Fetch
//            User user = userRepository.findUserWithHouses(4);
//            System.out.println(user);
//            System.out.println(user.getHouseList());

//            // Using Feature Of BiDirectional Association
//            Optional<User> user = userRepository.findById(4);
//            List<House> houses = houseRepository.findHouseByUserId(4);
//            System.out.println(user.get());
//            System.out.println(houses);
        }
    }

}
