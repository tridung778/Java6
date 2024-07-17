package com.example.java6_lab5.database;

import com.example.java6_lab5.model.Category;
import com.example.java6_lab5.model.Product;
import com.example.java6_lab5.model.Student;
import com.example.java6_lab5.repository.CategoryRepository;
import com.example.java6_lab5.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Configuration
public class DB {

    @Bean
    CommandLineRunner initDatabase(StudentRepository studentRepository, CategoryRepository categoryRepository) {
        return args -> {
            Student st1 = new Student("alexey@gmail.com", "Alexey", 5.0, true, "Viet Nam");
            Student st2 = new Student("john@gmail.com", "John", 6.0, false, "USA");
            Student st3 = new Student("jane@gmail.com", "Jane", 7.0, true, "USA");
            Student st4 = new Student("billy@gmail.com", "Billy", 8.0, false, "USA");
            Student st5 = new Student("mark@gmail.com", "Mark", 9.0, true, "Viet Nam");
            studentRepository.saveAll(List.of(st1, st2, st3, st4, st5));

            Category cat1 = new Category(UUID.randomUUID(),"Đồng hồ");
            categoryRepository.save(cat1);

//            Product p1 = new Product(UUID.randomUUID(),"Java", "image", new Date(), 100.0, true);

        };
    }
}
