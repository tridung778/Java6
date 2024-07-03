package com.example.java6_lab2.controllers;

import com.example.java6_lab2.beans.Student;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class Student2Controller {

    @GetMapping("/students/list")
    public String listStudents(Model model, @RequestParam("index") Optional<Integer> index) throws IOException {
        File file = new ClassPathResource("/static/data/students.json").getFile();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Student>> students = new TypeReference<>() {
        };
        List<Student> studentList = mapper.readValue(file, students);

        model.addAttribute("student", studentList.get(index.orElse(0)));
        model.addAttribute("students", studentList);
        return "students";
    }
}
