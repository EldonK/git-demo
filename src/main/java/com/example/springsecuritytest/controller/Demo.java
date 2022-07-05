package com.example.springsecuritytest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author k2001
 * Date 2022/6/29 9:37
 **/
@RestController
@RequestMapping("/test")
public class Demo {

    @GetMapping("demo")
    public String demo() {
        return "Hello World";
    }
}
