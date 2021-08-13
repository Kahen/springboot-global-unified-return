package com.example.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author kahen
 * @date 2021/8/13
 */
@Accessors(chain = true)
@Data
public class Student {
    private String id;
    private String name;
}
