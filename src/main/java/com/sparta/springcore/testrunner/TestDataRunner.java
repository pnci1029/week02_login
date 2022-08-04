//package com.sparta.springcore.testrunner;
//import com.sparta.springcore.dto.ItemDto;
//import com.sparta.springcore.model.Product;
//import com.sparta.springcore.model.User;
//import com.sparta.springcore.model.UserRoleEnum;
//import com.sparta.springcore.repository.ProductRepository;
//import com.sparta.springcore.repository.UserRepository;
//import com.sparta.springcore.service.ItemSearchService;
//import com.sparta.springcore.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Component
//public class TestDataRunner implements ApplicationRunner {
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    ItemSearchService itemSearchService;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//// 테스트 User 생성
//        User testUser = new User("1234", passwordEncoder.encode("1234"), "sugar@1.com", UserRoleEnum.USER);
//        User testUser1 = new User("2345", passwordEncoder.encode("2345"), "sugar@2.com", UserRoleEnum.USER);
//        User testUser2 = new User("3456", passwordEncoder.encode("3456"), "sugar@3.com", UserRoleEnum.USER);
//        User testUser3 = new User("4567", passwordEncoder.encode("4567"), "sugar@4.com", UserRoleEnum.USER);
//        User testUser4 = new User("5678", passwordEncoder.encode("5678"), "sugar@5.com", UserRoleEnum.USER);
//        testUser = userRepository.save(testUser);
//        testUser1 = userRepository.save(testUser1);
//        testUser2 = userRepository.save(testUser2);
//        testUser3 = userRepository.save(testUser3);
//        testUser4 = userRepository.save(testUser4);
//
//    }
//}