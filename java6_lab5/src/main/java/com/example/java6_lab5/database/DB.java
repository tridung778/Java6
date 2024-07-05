package com.example.java6_lab5.database;

import com.example.java6_lab5.model.Student;
import com.example.java6_lab5.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DB {

    @Bean
    CommandLineRunner initDatabase(StudentRepository studentRepository) {
        return args -> {
            Student st1 = new Student("1", "Alexey", 5.0, true, "Russia");
            Student st2 = new Student("2", "Alexey", 5.0, true, "Russia");
            Student st3 = new Student("3", "Alexey", 5.0, true, "Russia");
            Student st4 = new Student("4", "Alexey", 5.0, true, "Russia");
            Student st5 = new Student("5", "Alexey", 5.0, true, "Russia");
            studentRepository.saveAll(List.of(st1, st2, st3, st4, st5));
        };
    }
}
