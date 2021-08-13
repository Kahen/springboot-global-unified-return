package com.example.demo.controller;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kahen
 * @date 2021/8/13
 */
@RestController
@RequestMapping("test")
public class DemoController {
    @GetMapping
    public String list() {
        return "hello world";
    }

    @GetMapping("/wrong")
    public int error() {
        int i = 9 / 0;
        return i;
    }

    @GetMapping("error1")
    public void empty() {
        throw new RuntimeException("自定义异常");
    }

    @GetMapping("student")
    public List<Student> getStudent() {
        return List.of(new Student().setId("id").setName("张三"));
    }
}
