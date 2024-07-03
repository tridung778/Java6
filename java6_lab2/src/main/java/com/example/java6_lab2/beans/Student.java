package com.example.java6_lab2.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    String name;
    boolean gender;
    Double mark;
    Contact contact;
    List<String> subject;
}
