package com.example.java6_lab3.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    String email;
    String fullName;
    Double marks;
    Boolean gender;
    String country;
}
