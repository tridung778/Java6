package com.example.java6_lab1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    String name;
    Boolean gender = false;
    Double marks = 0.0;
}
