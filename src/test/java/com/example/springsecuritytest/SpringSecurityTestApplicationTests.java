package com.example.springsecuritytest;

import com.example.springsecuritytest.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@SpringBootTest
class SpringSecurityTestApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("123");
        log.info("encodedPassword={}", encodedPassword);
        log.info("isMatches={}", passwordEncoder.matches("1234", encodedPassword));
    }

}
