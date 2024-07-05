package com.example.java6_lab5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Students")
public class Student {
    @Id
    String email;
    String fullName;
    Double marks;
    Boolean gender;
    String country;
}
