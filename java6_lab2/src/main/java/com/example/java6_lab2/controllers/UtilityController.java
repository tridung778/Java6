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
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class UtilityController {

    @GetMapping("/demo/utility")
    public String listStudents(Model model) throws IOException {
        File file = new ClassPathResource("/static/data/students.json").getFile();
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Student>> students = new TypeReference<>() {
        };
        List<Student> studentList = mapper.readValue(file, students);

        model.addAttribute("students", studentList);
        model.addAttribute("now", new Date());
        return "utility";
    }
}
