package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
