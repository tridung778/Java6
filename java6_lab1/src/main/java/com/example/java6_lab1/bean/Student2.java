package com.example.java6_lab1.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student2 {

    String name;
    Boolean gender = false;
    Double marks = 0.0;
    Contact contact;
    List<String> subject;
}
